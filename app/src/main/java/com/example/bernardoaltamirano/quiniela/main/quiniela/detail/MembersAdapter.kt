package com.example.bernardoaltamirano.quiniela.main.quiniela.detail

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.model.User
import com.example.bernardoaltamirano.quiniela.util.DiffCallback
import kotlinx.android.synthetic.main.view_member_list_item.view.*

class MembersAdapter : RecyclerView.Adapter<MembersAdapter.Companion.MemberViewHolder>() {

    private val data: ArrayList<User> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.view_member_list_item, parent, false)
        return MemberViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    fun setData(members: List<User>?) {
        if (members != null) {
            val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(DiffCallback(data, members))
            data.clear()
            data.addAll(members)
            diffResult.dispatchUpdatesTo(this)
        } else {
            data.clear()
            notifyDataSetChanged()
        }
    }


    companion object {
        class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(user: User) {
                itemView.tv_name.text = "$adapterPosition. ${user.name}"
                //itemView.tv_username.text = user.username
            }
        }
    }
}