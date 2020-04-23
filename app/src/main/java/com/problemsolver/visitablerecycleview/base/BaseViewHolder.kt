package com.problemsolver.visitablerecycleview.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : BaseViewItem>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(data: T)
    open fun onClickListener(listener: (View) -> Unit) {}
    open fun onLongClickListener(listener: (View) -> Unit) {}
}