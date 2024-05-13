package com.mrapps.horizontalstackedchartview

import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrapps.horizontalstackedchartview.databinding.ItemLegendBinding

class LegendAdapter(private val legendData: MutableList<Data>) :
    RecyclerView.Adapter<LegendAdapter.LegendViewHolder>() {

    private var legendTextColor: Int = Color.BLACK
    private var legendValueTextColor: Int = Color.BLACK
    private var legendTextSize: Float = 14f
    private var legendValueTextSize: Float = 14f

    fun setLegendTextColor(color: Int) {
        legendTextColor = color
        notifyDataSetChanged() // Notify adapter to update views with new legend text color
    }

    fun setLegendValueTextColor(color: Int) {
        legendValueTextColor = color
        notifyDataSetChanged() // Notify adapter to update views with new legend value text color
    }

    fun setLegendTextSize(size: Float) {
        legendTextSize = size
        notifyDataSetChanged() // Notify adapter to update views with new legend text size
    }

    fun setLegendValueTextSize(size: Float) {
        legendValueTextSize = size
        notifyDataSetChanged() // Notify adapter to update views with new legend value text size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendViewHolder {
        val binding = ItemLegendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LegendViewHolder, position: Int) {
        val data = legendData[position]

        // Set legend text color and size
        holder.binding.labelTextView.setTextColor(legendTextColor)
        holder.binding.labelTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, legendTextSize)

        // Set legend value text color and size
        holder.binding.valueTextView.setTextColor(legendValueTextColor)
        holder.binding.valueTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, legendValueTextSize)


        holder.binding.colorView.setCardBackgroundColor(data.color)
        holder.binding.labelTextView.text = data.name
        holder.binding.valueTextView.text = buildString {
            append(data.value.toString())
            append(" %")
        }
    }

    override fun getItemCount(): Int {
        return legendData.size
    }


    fun updateData(newData: List<Data>) {
        legendData.clear()
        legendData.addAll(newData)
        notifyDataSetChanged()
    }



    class LegendViewHolder(val binding: ItemLegendBinding) :
        RecyclerView.ViewHolder(binding.root)
}