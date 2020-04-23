package com.problemsolver.visitablerecycleview.base

import android.view.View

abstract class ItemTypeFactory {
    abstract fun onCreateViewHolder(
        view: View,
        viewType: Int
    ): BaseViewHolder<BaseViewItem>

    abstract fun type(item: BaseViewItem): Int
}