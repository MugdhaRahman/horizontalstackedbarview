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
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return legendData.size
    }

    inner class LegendViewHolder(private val binding: ItemLegendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.colorView.setCardBackgroundColor(data.color)
            binding.labelTextView.text = data.name
            binding.valueTextView.text = data.value.toString()
        }
    }
}