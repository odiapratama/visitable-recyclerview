package com.problemsolver.visitablerecycleview.viewholder

import android.view.View
import com.problemsolver.visitablerecycleview.R
import com.problemsolver.visitablerecycleview.base.BaseViewHolder
import com.problemsolver.visitablerecycleview.databinding.OverviewLayoutBinding
import com.problemsolver.visitablerecycleview.model.Overview

class OverviewViewHolder(view: View) : BaseViewHolder<Overview>(view) {

    companion object {
        const val layout = R.layout.overview_layout
    }

    private val binding = OverviewLayoutBinding.bind(view)

    override fun bind(data: Overview) {
        binding.item1.tvItem.text = data.title1
        binding.item2.tvItem.text = data.title2
        binding.item3.tvItem.text = data.title3
        binding.item4.tvItem.text = data.title4
    }

    override fun onClickListener(listener: (View) -> Unit) {
        binding.item1.root.setOnClickListener { listener.invoke(it) }
        binding.item2.root.setOnClickListener { listener.invoke(it) }
        binding.item3.root.setOnClickListener { listener.invoke(it) }
        binding.item4.root.setOnClickListener { listener.invoke(it) }
    }

    override fun onLongClickListener(listener: (View) -> Unit) {
        binding.item1.root.setOnLongClickListener {
            listener.invoke(it)
            true
        }
        binding.item2.root.setOnLongClickListener {
            listener.invoke(it)
            true
        }
        binding.item3.root.setOnLongClickListener {
            listener.invoke(it)
            true
        }
        binding.item4.root.setOnLongClickListener {
            listener.invoke(it)
            true
        }
    }
}