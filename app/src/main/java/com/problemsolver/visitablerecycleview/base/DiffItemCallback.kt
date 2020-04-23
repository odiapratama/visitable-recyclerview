package com.problemsolver.visitablerecycleview.base

import androidx.recyclerview.widget.DiffUtil

class DiffItemCallback(private val factory: ItemTypeFactory) : DiffUtil.ItemCallback<BaseViewItem>() {

    override fun areItemsTheSame(oldItem: BaseViewItem, newItem: BaseViewItem): Boolean =
        oldItem.typeOf(factory) == newItem.typeOf(factory)

    override fun areContentsTheSame(oldItem: BaseViewItem, newItem: BaseViewItem): Boolean =
        oldItem.typeOf(factory) == newItem.typeOf(factory)
}