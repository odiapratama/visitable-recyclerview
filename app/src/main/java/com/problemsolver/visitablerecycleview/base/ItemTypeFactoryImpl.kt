package com.problemsolver.visitablerecycleview.base

import android.view.View
import com.problemsolver.visitablerecycleview.model.Goods
import com.problemsolver.visitablerecycleview.model.Header
import com.problemsolver.visitablerecycleview.model.Overview
import com.problemsolver.visitablerecycleview.viewholder.GoodsViewHolder
import com.problemsolver.visitablerecycleview.viewholder.HeaderViewHolder
import com.problemsolver.visitablerecycleview.viewholder.OverviewViewHolder
import java.lang.ClassCastException

class ItemTypeFactoryImpl : ItemTypeFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(view: View, viewType: Int): BaseViewHolder<BaseViewItem> {
        return when (viewType) {
            HeaderViewHolder.layout -> HeaderViewHolder(view) as BaseViewHolder<BaseViewItem>
            OverviewViewHolder.layout -> OverviewViewHolder(view) as BaseViewHolder<BaseViewItem>
            GoodsViewHolder.layout -> GoodsViewHolder(view) as BaseViewHolder<BaseViewItem>
            else -> onCreateViewHolder(view, viewType)
        }
    }

    override fun type(item: BaseViewItem): Int {
        return when (item) {
            is Header -> HeaderViewHolder.layout
            is Overview -> OverviewViewHolder.layout
            is Goods -> GoodsViewHolder.layout
            else -> throw ClassCastException()
        }
    }
}