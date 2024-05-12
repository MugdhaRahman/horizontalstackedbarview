import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrapps.horizontalstackedchartview.Data
import com.mrapps.horizontalstackedchartview.R

class LegendAdapter(private val legendData: List<Data>) :
    RecyclerView.Adapter<LegendAdapter.LegendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_legend, parent, false)
        return LegendViewHolder(view)
    }

    override fun onBindViewHolder(holder: LegendViewHolder, position: Int) {
        val data = legendData[position]
        holder.colorIndicator.setBackgroundColor(data.color)
        holder.legendLabel.text = data.name
    }

    override fun getItemCount(): Int {
        return legendData.size
    }

    class LegendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorIndicator: View = itemView.findViewById(R.id.colorView)
        val legendLabel: TextView = itemView.findViewById(R.id.labelTextView)
    }
}
