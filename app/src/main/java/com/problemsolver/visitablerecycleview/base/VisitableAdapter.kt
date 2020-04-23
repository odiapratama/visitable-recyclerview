package com.problemsolver.visitablerecycleview.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

typealias ItemClickListener = ((BaseViewItem, View) -> Unit)

class VisitableAdapter(
    private val factory: ItemTypeFactory,
    private var onClick: ItemClickListener? = null,
    private var onLongClick: ItemClickListener? = null
) : ListAdapter<BaseViewItem, BaseViewHolder<BaseViewItem>>(DiffItemCallback(factory)) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseViewItem> {
        return factory.onCreateViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false), viewType).apply {
            onClickListener { onClick?.invoke(currentList[absoluteAdapterPosition], it) }
            onLongClickListener { onLongClick?.invoke(currentList[absoluteAdapterPosition], it) }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseViewItem>, position: Int) = holder.bind(currentList[position])

    override fun getItemViewType(position: Int): Int = currentList[position].typeOf(factory)
}