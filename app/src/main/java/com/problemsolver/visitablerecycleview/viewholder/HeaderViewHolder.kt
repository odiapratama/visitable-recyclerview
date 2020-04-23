package com.problemsolver.visitablerecycleview.viewholder

import android.view.View
import com.problemsolver.visitablerecycleview.R
import com.problemsolver.visitablerecycleview.base.BaseViewHolder
import com.problemsolver.visitablerecycleview.databinding.HeaderLayoutBinding
import com.problemsolver.visitablerecycleview.model.Header

class HeaderViewHolder(view: View) : BaseViewHolder<Header>(view) {

    companion object {
        const val layout = R.layout.header_layout
    }

    private val binding = HeaderLayoutBinding.bind(view)

    override fun bind(data: Header) {
        binding.header.tvItem.text = data.title
    }

    override fun onClickListener(listener: (View) -> Unit) {
        binding.clContent.setOnClickListener { listener.invoke(it) }
    }

    override fun onLongClickListener(listener: (View) -> Unit) {
        binding.clContent.setOnLongClickListener {
            listener.invoke(it)
            true
        }
    }
}