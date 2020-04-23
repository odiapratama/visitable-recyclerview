package com.problemsolver.visitablerecycleview.base

interface BaseViewItem {
    fun typeOf(itemTypeFactory: ItemTypeFactory): Int = itemTypeFactory.type(this)
}