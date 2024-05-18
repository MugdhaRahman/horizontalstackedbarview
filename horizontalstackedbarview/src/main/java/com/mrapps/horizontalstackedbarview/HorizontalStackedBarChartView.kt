package com.mrapps.horizontalstackedbarview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
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
    private var legendView: LegendView? = null
    private var orientation: Int = 0  // 0 for horizontal, 1 for vertical

    private val horizontalLeftRadius: FloatArray =
        floatArrayOf(cornerRadius, cornerRadius, 0f, 0f, 0f, 0f, cornerRadius, cornerRadius)
    private val horizontalRightRadius: FloatArray =
        floatArrayOf(0f, 0f, cornerRadius, cornerRadius, cornerRadius, cornerRadius, 0f, 0f)
    private val verticalTopRadius: FloatArray =
        floatArrayOf(cornerRadius, cornerRadius, cornerRadius, cornerRadius, 0f, 0f, 0f, 0f)
    private val verticalBottomRadius: FloatArray =
        floatArrayOf(0f, 0f, 0f, 0f, cornerRadius, cornerRadius, cornerRadius, cornerRadius)
    private val flatRadius: FloatArray = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

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
                ta.getFloat(R.styleable.HorizontalStackedBarChartView_barCornerRadius, cornerRadius)
            backgroundColor = ta.getColor(
                R.styleable.HorizontalStackedBarChartView_barColor,
                ContextCompat.getColor(context, R.color.default_bar_color)
            )
            orientation = ta.getInt(R.styleable.HorizontalStackedBarChartView_orientation, 0)
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
        calculatePercentages()
        show()
        legendView?.setLegendData(dataList)
    }

    fun setLegendView(legendView: LegendView) {
        this.legendView = legendView
        legendView.setLegendData(dataList)
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

        if (orientation == 0) {
            drawHorizontalBarChart(canvas)
        } else {
            drawVerticalBarChart(canvas)
        }
    }

    private fun drawHorizontalBarChart(canvas: Canvas) {
        canvas.drawRoundRect(mainRect, cornerRadius, cornerRadius, mainPaint)

        var starting = true
        val totalValue = dataList.sumOf { it.value }

        var currentWidth = 0f
        for ((index, data) in dataList.withIndex()) {
            val newWidth = fullWidth * data.value / totalValue
            bounds.top = 0
            bounds.left = 0
            bounds.right = newWidth.toInt()
            bounds.bottom = fullHeight

            newDrawable.bounds = bounds

            newDrawable.cornerRadii = when {
                starting -> {
                    starting = false
                    horizontalLeftRadius
                }
                index == dataList.lastIndex -> horizontalRightRadius
                else -> flatRadius
            }

            newDrawable.setColor(data.color)
            newDrawable.draw(canvas)
            canvas.translate(newWidth.toFloat(), 0f)
            currentWidth += newWidth.toFloat()
        }

        currentPercentage = toPercentage(currentWidth)
    }

    private fun drawVerticalBarChart(canvas: Canvas) {
        canvas.drawRoundRect(mainRect, cornerRadius, cornerRadius, mainPaint)

        var starting = true
        val totalValue = dataList.sumOf { it.value }

        var currentHeight = 0f
        for ((index, data) in dataList.withIndex()) {
            val newHeight = fullHeight * data.value / totalValue
            bounds.top = 0
            bounds.left = 0
            bounds.right = fullWidth
            bounds.bottom = newHeight.toInt()

            newDrawable.bounds = bounds

            newDrawable.cornerRadii = when {
                starting -> {
                    starting = false
                    verticalTopRadius
                }
                index == dataList.lastIndex -> verticalBottomRadius
                else -> flatRadius
            }

            newDrawable.setColor(data.color)
            newDrawable.draw(canvas)
            canvas.translate(0f, newHeight.toFloat())
            currentHeight += newHeight.toFloat()
        }

        currentPercentage = toPercentage(currentHeight)
    }

    private fun toPercentage(rectSize: Float): Float {
        return if (orientation == 0) {
            rectSize * 100 / fullWidth
        } else {
            rectSize * 100 / fullHeight
        }
    }
}
