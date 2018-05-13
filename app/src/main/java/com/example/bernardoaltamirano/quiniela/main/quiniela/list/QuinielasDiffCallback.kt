package com.example.bernardoaltamirano.quiniela.main.quiniela.list

import android.support.v7.util.DiffUtil
import com.example.bernardoaltamirano.quiniela.model.Quiniela

class QuinielasDiffCallback(private val oldList: List<Quiniela>, private val newList: List<Quiniela>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}