package com.mrapps.horizontalstackedchartview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrapps.horizontalstackedchartview.databinding.ItemLegendBinding

class LegendAdapter(private val legendData: List<Data>) :
    RecyclerView.Adapter<LegendAdapter.LegendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendViewHolder {
        val binding = ItemLegendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LegendViewHolder, position: Int) {
        val data = legendData[position]

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

    class LegendViewHolder(val binding: ItemLegendBinding) :
        RecyclerView.ViewHolder(binding.root)
}