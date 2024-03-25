package com.mrapps.horizontalstackedchartview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class LegendView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    private var legendOrientationHorizontal: Boolean = true
    private var legendSize: Float = 16f

    private var dataList: MutableList<Data> = mutableListOf()

    private var mainPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var fullWidth: Int = 0
    private var fullHeight: Int = 0

    init {
        init(attrs)
    }


    @SuppressLint("CustomViewStyleable")
    private fun init(set: AttributeSet?) {
        set?.let {
            val typedArray =
                context.obtainStyledAttributes(set, R.styleable.LegendView)
            legendOrientationHorizontal = typedArray.getBoolean(
                R.styleable.LegendView_legendHorizontal,
                true
            )
            legendSize =
                typedArray.getDimension(
                    R.styleable.LegendView_legendSize,
                    16f
                )
            typedArray.recycle()
        }
    }

    fun setData(dataList: MutableList<Data>) {
        this.dataList = dataList
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        fullWidth = width
        fullHeight = height

        if (legendOrientationHorizontal) {
            drawLegendHorizontal(canvas)
        } else {
            drawLegendVertical(canvas)
        }
    }

    private fun drawLegendHorizontal(canvas: Canvas) {
        val legendItemWidth = fullWidth / dataList.size.toFloat()
        val legendItemHeight = legendSize * 2 // Adjust this as needed for spacing
        var startX = 0f

        for (data in dataList) {
            mainPaint.color = data.color
            val legendLeft = startX
            val legendTop = fullHeight.toFloat() - legendItemHeight // Adjust vertical position
            val legendRight = startX + legendItemWidth
            val legendBottom = fullHeight.toFloat() // Adjust vertical position
            canvas.drawRect(legendLeft, legendTop, legendRight, legendBottom, mainPaint)

            mainPaint.textSize = legendSize
            mainPaint.color = ContextCompat.getColor(context, android.R.color.black)
            val textX = startX + legendItemWidth / 2 // Center text horizontally
            val textY =
                fullHeight.toFloat() - legendItemHeight / 2 + legendSize / 2 // Adjust vertical position
            canvas.drawText(data.name, textX, textY, mainPaint)

            Log.e(
                "HorizontalStackedBarChartView",
                "Legend item: $legendLeft, $legendTop, $legendRight, $legendBottom"
            )

            startX += legendItemWidth
        }
    }


    private fun drawLegendVertical(canvas: Canvas) {
        var startY = fullHeight.toFloat() + legendSize

        for (data in dataList) {
            mainPaint.color = data.color
            canvas.drawRect(0f, startY, legendSize, startY + legendSize, mainPaint)

            mainPaint.textSize = legendSize
            mainPaint.color = ContextCompat.getColor(context, android.R.color.black)
            canvas.drawText(data.name, legendSize * 1.5f, startY + legendSize * 1.5f, mainPaint)

            startY += legendSize * 2
        }
    }


}
