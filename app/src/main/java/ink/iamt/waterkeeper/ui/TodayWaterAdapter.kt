package ink.iamt.waterkeeper.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HeaderViewListAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ink.iamt.waterkeeper.R
import ink.iamt.waterkeeper.Record
import kotlinx.android.synthetic.main.item_today_rv_item.view.*

class TodayWaterAdapter() : RecyclerView.Adapter<TodayWaterAdapter.TodayWaterViewHolder>() {

    open inner class TodayWaterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class TodayWaterHeaderHolder(itemView: View) : TodayWaterViewHolder(itemView)

    val diffCallback = object : DiffUtil.ItemCallback<Record>() {
        override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Record>) = differ.submitList(list)

    override fun getItemViewType(position: Int) = when(position) {
        0 -> HEADER
        else -> CONTENT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType) {
        HEADER -> TodayWaterHeaderHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_today_rv_header, parent, false)
        )
        else -> TodayWaterViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_today_rv_item, parent, false)
        )
    }

    override fun getItemCount() = differ.currentList.size + 1

    override fun onBindViewHolder(holder: TodayWaterViewHolder, position: Int) {
        when (holder.itemViewType) {
            CONTENT -> holder.itemView.apply {
                val record = differ.currentList[position - 1]
                tvIdInRv.text = position.toString()
                tvTimeInRv.text = record.time?.hour.toString() + " : " + record.time?.minute.toString()
                tvAmountInRv.text = record.amount.toString()
            }
        }
    }

    companion object {
        val HEADER = 1
        val CONTENT = 2
    }
}