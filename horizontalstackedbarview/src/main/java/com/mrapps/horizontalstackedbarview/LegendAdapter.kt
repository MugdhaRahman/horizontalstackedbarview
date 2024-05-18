package com.mrapps.horizontalstackedbarview

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.mrapps.horizontalstackedbarview.databinding.ItemLegendBinding

@SuppressLint("NotifyDataSetChanged")
class LegendAdapter(private val legendData: MutableList<Data>) :
    RecyclerView.Adapter<LegendAdapter.LegendViewHolder>() {

    private var legendTextColor = R.color.default_legend_text_color
    private var legendValueTextColor = R.color.default_legend_sub_text_color
    private var legendTextSize = 15f
    private var legendValueTextSize = 12f
    private var legendDotHeight = 40f
    private var legendDotWidth = 40f
    private var legendDotCornerRadius = 10f
    private var LegendDotSpacing = 20f
    private var legendValueSpacing = 20f
    private var legendValue = false
    private var legendValueShow = true

    fun setLegendTextColor(color: Int) {
        legendTextColor = color
        notifyDataSetChanged()
    }

    fun setLegendValueTextColor(color: Int) {
        legendValueTextColor = color
        notifyDataSetChanged()
    }

    fun setLegendTextSize(size: Float) {
        legendTextSize = size
        notifyDataSetChanged()
    }

    fun setLegendValueTextSize(size: Float) {
        legendValueTextSize = size
        notifyDataSetChanged()
    }

    fun setLegendDotHeight(size: Float) {
        legendDotHeight = size
        notifyDataSetChanged()
    }

    fun setLegendDotWidth(size: Float) {
        legendDotWidth = size
        notifyDataSetChanged()
    }

    fun setLegendDotCornerRadius(size: Float) {
        legendDotCornerRadius = size
        notifyDataSetChanged()
    }

    fun setLegendValue(value: Boolean) {
        legendValue = value
        notifyDataSetChanged()
    }

    fun setLegendValueShow(value: Boolean) {
        legendValueShow = value
        notifyDataSetChanged()
    }

    fun setLegendDotSpacing(value: Float) {
        LegendDotSpacing = value
        notifyDataSetChanged()
    }

    fun setLegendValueSpacing(value: Float) {
        legendValueSpacing = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendViewHolder {
        val binding = ItemLegendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegendViewHolder(binding)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: LegendViewHolder, position: Int) {
        val data = legendData[position]

        holder.binding.labelTextView.setTextColor(legendTextColor)
        holder.binding.labelTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, legendTextSize)

        holder.binding.valueTextView.setTextColor(legendValueTextColor)
        holder.binding.valueTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, legendValueTextSize)

        holder.binding.colorView.setCardBackgroundColor(data.color)

        holder.binding.colorView.radius = legendDotCornerRadius
        holder.binding.colorView.layoutParams.height = legendDotHeight.toInt()
        holder.binding.colorView.layoutParams.width = legendDotWidth.toInt()

        val layoutParams = holder.binding.colorView.layoutParams as MarginLayoutParams
        layoutParams.marginEnd = LegendDotSpacing.toInt()
        holder.binding.colorView.layoutParams = layoutParams

        holder.binding.labelTextView.text = data.name

        if (legendValue) {
            holder.binding.valueTextView.text = data.value.toString()
        } else {
            holder.binding.valueTextView.text = buildString {
                append(data.percentage.toString())
                append(" %")
            }
        }

        if (legendValueShow) {
            holder.binding.valueTextView.visibility = VISIBLE
        } else {
            holder.binding.valueTextView.visibility = GONE
        }

        val valueLayoutParams = holder.binding.valueTextView.layoutParams as MarginLayoutParams
        valueLayoutParams.marginStart = legendValueSpacing.toInt()
        holder.binding.valueTextView.layoutParams = valueLayoutParams


    }

    override fun getItemCount(): Int {
        return legendData.size
    }


    internal fun updateData(newData: List<Data>) {
        legendData.clear()
        legendData.addAll(newData)
        notifyDataSetChanged()
    }

    class LegendViewHolder(val binding: ItemLegendBinding) :
        RecyclerView.ViewHolder(binding.root)
}