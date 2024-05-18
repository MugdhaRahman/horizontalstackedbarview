package com.mrapps.horizontalstackedbarview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LegendView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val legendRecyclerView: RecyclerView
    private var legendAdapter: LegendAdapter

    private var dataList: MutableList<Data> = mutableListOf()

    var legendTextColor: Int = Color.BLACK
        set(value) {
            field = value
            legendAdapter.setLegendTextColor(value)
        }

    var legendValueTextColor: Int = Color.BLACK
        set(value) {
            field = value
            legendAdapter.setLegendValueTextColor(value)
        }

    var legendTextSize: Float = 15f
        set(value) {
            field = value
            legendAdapter.setLegendTextSize(value)
        }

    var legendValueTextSize: Float = 15f
        set(value) {
            field = value
            legendAdapter.setLegendValueTextSize(value)
        }

    var legendDotHeight: Float = 40f
        set(value) {
            field = value
            legendAdapter.setLegendDotHeight(value)
        }

    var legendDotWidth: Float = 40f
        set(value) {
            field = value
            legendAdapter.setLegendDotWidth(value)
        }

    var legendDotCornerRadius: Float = 10f
        set(value) {
            field = value
            legendAdapter.setLegendDotCornerRadius(value)
        }

    var legendValue: Boolean = false
        set(value) {
            field = value
            legendAdapter.setLegendValue(value)
        }

    var legendValueShow: Boolean = true
        set(value) {
            field = value
            legendAdapter.setLegendValueShow(value)
        }

    var legendDotSpacing: Float = 10f
        set(value) {
            field = value
            legendAdapter.setLegendDotSpacing(value)
        }

    var legendValueSpacing: Float = 10f
        set(value) {
            field = value
            legendAdapter.setLegendValueSpacing(value)
        }

    var setHorizontalSpanCount: Int = 2
        set(value) {
            field = value
            if (setLegendHorizontal) {
                legendRecyclerView.layoutManager = GridLayoutManager(context, value)
            }
        }

    var setLegendHorizontal: Boolean = false
        set(value) {
            field = value
            legendRecyclerView.layoutManager = if (value) {
                GridLayoutManager(context, setHorizontalSpanCount)
            } else {
                LinearLayoutManager(context)
            }
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.legend_recycler_view, this, true)
        legendRecyclerView = findViewById(R.id.legendRecyclerView)
        legendAdapter = LegendAdapter(mutableListOf())
        legendRecyclerView.adapter = legendAdapter
        legendRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun updateLegendData(newDataList: List<Data>) {
        dataList.clear()
        dataList.addAll(newDataList)
        legendAdapter.updateData(dataList)
    }

    internal fun setLegendData(newDataList:  List<Data>) {
        updateLegendData(newDataList)
    }
}

