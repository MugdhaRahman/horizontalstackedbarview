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
import android.view.View
import androidx.core.content.ContextCompat

class HorizontalStackedBarChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var dataList: MutableList<Data> = mutableListOf()
    private var cornerRadius = 10f
    private var backgroundColor: Int = ContextCompat.getColor(context, R.color.default_bar_color)
    private var mainRect: RectF = RectF()
    private var bounds: Rect = Rect()
    private var mainPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var newDrawable: GradientDrawable = GradientDrawable()

    private val tbLeftRadius: FloatArray =
        floatArrayOf(cornerRadius, cornerRadius, 0f, 0f, 0f, 0f, cornerRadius, cornerRadius)
    private val flatRadius: FloatArray = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    private val tbRightRadius: FloatArray =
        floatArrayOf(0f, 0f, cornerRadius, cornerRadius, cornerRadius, cornerRadius, 0f, 0f)

    private var currentPercentage: Float = 0f

    private var fullWidth: Int = 0
    private var fullHeight: Int = 0


    init {
        init(attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(set: AttributeSet?) {
        set?.let {
            val ta = context.obtainStyledAttributes(set, R.styleable.HorizontalStackedBarChartView)
            cornerRadius =
                ta.getFloat(R.styleable.HorizontalStackedBarChartView_BarCornerRadius, cornerRadius)
            backgroundColor = ta.getColor(
                R.styleable.HorizontalStackedBarChartView_barColor,
                ContextCompat.getColor(context, R.color.default_bar_color)
            )
            ta.recycle()
        }

        mainRect = RectF()
        mainPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        bounds = Rect()
        dataList = mutableListOf()

        newDrawable = GradientDrawable()
        newDrawable.shape = GradientDrawable.RECTANGLE

        invalidate()
    }




    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        fullWidth = w
        fullHeight = h
        invalidate()
    }

    fun addData(newDataId: Int, newValue: Double, newColorRes: Int, newDataName: String) {
        dataList.add(Data(newDataId, newColorRes, newValue, newDataName))
        calculatePercentages() // Calculate percentages after adding data
        show() // Automatically show the chart after adding data
    }

    private fun show() {
        invalidate()
    }

    private fun calculatePercentages() {
        val total = dataList.sumOf { it.value }
        for (data in dataList) {
            val percentage = (data.value * 100) / total
            data.percentage = percentage.toInt()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        fullWidth = width
        fullHeight = height

        mainRect.top = 0f
        mainRect.left = 0f
        mainRect.right = fullWidth.toFloat()
        mainRect.bottom = fullHeight.toFloat()
        mainPaint.color = backgroundColor
        canvas.drawRoundRect(mainRect, cornerRadius, cornerRadius, mainPaint)

        var starting = true
        var totalValue = 0.00
        for (data in dataList) {
            totalValue += data.value
        }

        var currentWidth = 0f
        for ((index, data) in dataList.withIndex()) {
            val newWidth = fullWidth * data.value / totalValue
            bounds.top = 0
            bounds.left = 0
            bounds.right = newWidth.toInt()
            bounds.bottom = fullHeight

            if (starting) {
                newDrawable.cornerRadii = tbLeftRadius
                starting = false
            } else if (index == dataList.lastIndex) {
                newDrawable.cornerRadii = tbRightRadius
            } else {
                newDrawable.cornerRadii = flatRadius
            }

            newDrawable.setColor(data.color)
            newDrawable.bounds = bounds
            newDrawable.draw(canvas)
            canvas.translate(newWidth.toFloat(), 0f)
            currentWidth += newWidth.toFloat()

        }



//        if (legendOrientationHorizontal) {
//            drawLegendHorizontal(canvas)
//        } else {
//            drawLegendVertical(canvas)
//        }


        currentPercentage = toPercentage(currentWidth)
    }





    private fun toPercentage(rectWidth: Float): Float {
        return rectWidth * 100 / fullWidth
    }
}