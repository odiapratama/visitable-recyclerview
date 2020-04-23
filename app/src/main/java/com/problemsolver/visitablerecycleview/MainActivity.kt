package com.problemsolver.visitablerecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.problemsolver.visitablerecycleview.base.BaseViewItem
import com.problemsolver.visitablerecycleview.base.ItemTypeFactoryImpl
import com.problemsolver.visitablerecycleview.base.VisitableAdapter
import com.problemsolver.visitablerecycleview.databinding.ActivityMainBinding
import com.problemsolver.visitablerecycleview.model.Goods
import com.problemsolver.visitablerecycleview.model.Header
import com.problemsolver.visitablerecycleview.model.Overview

class MainActivity : AppCompatActivity() {

    private val visitableAdapter by lazy {
        VisitableAdapter(
            ItemTypeFactoryImpl(),
            ::onClicked,
            ::onLongClicked
        )
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.rvMain.adapter = visitableAdapter

        val listItem: MutableList<BaseViewItem> = mutableListOf()

        val header = Header("Hallo")
        listItem.add(header)

        val overview = Overview("Bandung", "Jakarta", "Padang", "Aceh")
        listItem.add(overview)

        val goods = Goods(listOf("Macbook Pro", "Acer", "Asus", "Samsung", "Windows"))
        listItem.add(goods)

        listItem.add(header)
        listItem.add(overview)
        listItem.add(goods)

        visitableAdapter.submitList(listItem)
    }

    private fun onClicked(viewItem: BaseViewItem, view: View) {
        when (viewItem) {
            is Header -> {
                when (view.id) {
                    R.id.clContent -> showToast(viewItem.title, "Clicked")
                }
            }
            is Overview -> {
                when (view.id) {
                    R.id.item1 -> showToast(viewItem.title1, "Clicked")
                    R.id.item2 -> showToast(viewItem.title2, "Clicked")
                    R.id.item3 -> showToast(viewItem.title3, "Clicked")
                    R.id.item4 -> showToast(viewItem.title4, "Clicked")
                }
            }
        }
    }

    private fun onLongClicked(viewItem: BaseViewItem, view: View) {
        when (viewItem) {
            is Header -> {
                when (view.id) {
                    R.id.clContent -> showToast(viewItem.title, "Long Clicked")
                }
            }
            is Overview -> {
                when (view.id) {
                    R.id.item1 -> showToast(viewItem.title1, "Long Clicked")
                    R.id.item2 -> showToast(viewItem.title2, "Long Clicked")
                    R.id.item3 -> showToast(viewItem.title3, "Long Clicked")
                    R.id.item4 -> showToast(viewItem.title4, "Long Clicked")
                }
            }
        }
    }

    private fun showToast(text: String, prefix: String) {
        Toast.makeText(this, "$prefix $text", Toast.LENGTH_SHORT).show()
    }
}
