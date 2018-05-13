package com.example.bernardoaltamirano.quiniela.main.quiniela.list

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.model.Quiniela

import kotlinx.android.synthetic.main.view_quiniela_list_item.view.*



class QuinielasAdapter(private val listener: QuinielaClickedListener): RecyclerView.Adapter<QuinielasAdapter.Companion.QuinielaViewHolder>() {

    private val data: ArrayList<Quiniela> = arrayListOf()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuinielaViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.view_quiniela_list_item, parent, false)
        return QuinielaViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: QuinielaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemId(position: Int): Long {
        return data[position].id!!
    }

    fun setData(quinielas: List<Quiniela>?) {
        if (quinielas != null) {
            val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(QuinielasDiffCallback(data, quinielas))
            data.clear()
            data.addAll(quinielas)
            diffResult.dispatchUpdatesTo(this)
        } else {
            data.clear()
            notifyDataSetChanged()
        }
    }

    interface QuinielaClickedListener {
        fun onQuinielaClicked(quiniela: Quiniela)
    }

    companion object {
        class QuinielaViewHolder(itemView: View, listener: QuinielaClickedListener): RecyclerView.ViewHolder(itemView) {

            private var quiniela: Quiniela? = null

            init {
                itemView.setOnClickListener {
                    if (quiniela != null) {
                        listener.onQuinielaClicked(quiniela!!)
                    }
                }
            }

            fun bind(quiniela: Quiniela) {
                this.quiniela = quiniela
                itemView.tv_quiniela_name.text = quiniela.name
                itemView.tv_members.text = "Integrantes: ${quiniela.members}"
                itemView.tv_money.text = "$${quiniela.members!! * quiniela.price!!}"
            }
        }
    }
}