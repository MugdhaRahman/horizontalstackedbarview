import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrapps.horizontalstackedchartview.LegendItem
import com.mrapps.horizontalstackedchartview.R

class LegendAdapter(private val legendItems: List<LegendItem>) :
    RecyclerView.Adapter<LegendAdapter.LegendViewHolder>() {

    inner class LegendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val colorView: View = itemView.findViewById(R.id.colorView)
        private val labelTextView: TextView = itemView.findViewById(R.id.labelTextView)

        fun bind(legendItem: LegendItem) {
            colorView.setBackgroundColor(legendItem.color)
            labelTextView.text = legendItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_legend, parent, false)
        return LegendViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LegendViewHolder, position: Int) {
        holder.bind(legendItems[position])
    }

    override fun getItemCount(): Int {
        return legendItems.size
    }
}
