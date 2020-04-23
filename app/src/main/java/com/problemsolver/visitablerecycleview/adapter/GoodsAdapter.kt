package com.problemsolver.visitablerecycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.problemsolver.visitablerecycleview.R

class GoodsAdapter(private val data: List<String>) : RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onClickListener(view: View, item: String)
        fun onLongClickListener(view: View, item: String)
    }

    class GoodsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return GoodsViewHolder(layout)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
        val item = data[position]
        holder.tvTitle.text = item
        holder.tvTitle.setOnClickListener {
            onItemClickListener?.onClickListener(it, item)
        }
        holder.tvTitle.setOnLongClickListener {
            onItemClickListener?.onLongClickListener(it, item)
            true
        }
    }
}