package com.problemsolver.visitablerecycleview.viewholder

import android.view.View
import com.problemsolver.visitablerecycleview.R
import com.problemsolver.visitablerecycleview.adapter.GoodsAdapter
import com.problemsolver.visitablerecycleview.base.BaseViewHolder
import com.problemsolver.visitablerecycleview.databinding.GoodsLayoutBinding
import com.problemsolver.visitablerecycleview.model.Goods

class GoodsViewHolder(view: View) : BaseViewHolder<Goods>(view) {

    companion object {
        const val layout = R.layout.goods_layout
    }

    private val binding = GoodsLayoutBinding.bind(view)

    override fun bind(data: Goods) {
        val goodsAdapter = GoodsAdapter(data.data)
        binding.rvGoods.adapter = goodsAdapter
        goodsAdapter.onItemClickListener = object : GoodsAdapter.OnItemClickListener {
            override fun onClickListener(view: View, item: String) {
                TODO("Not yet implemented")
            }

            override fun onLongClickListener(view: View, item: String) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onClickListener(listener: (View) -> Unit) {
        super.onClickListener(listener)
    }

    override fun onLongClickListener(listener: (View) -> Unit) {
        super.onLongClickListener(listener)
    }
}