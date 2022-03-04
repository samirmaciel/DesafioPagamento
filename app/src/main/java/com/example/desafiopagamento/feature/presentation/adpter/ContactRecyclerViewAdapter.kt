package com.example.desafiopagamento.feature.presentation.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopagamento.R
import com.example.desafiopagamento.feature.domain.model.User

class ContactRecyclerViewAdapter(val itemClick : (Int) -> Unit) :RecyclerView.Adapter<ContactRecyclerViewAdapter.MyViewHolder>() {

    var itemList : MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_contact, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(itemList[position], itemClick)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }


    class MyViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(user: User, itemClick: (Int) -> Unit) {
            itemView.findViewById<LinearLayout>(R.id.llItemContact).setOnClickListener {
                itemClick(user.id)
            }
            itemView.findViewById<ImageView>(R.id.ivItemUserImage)
                .setImageResource(user.drawableID)
            itemView.findViewById<TextView>(R.id.tvItemUserNickName).text = user.nickname
            itemView.findViewById<TextView>(R.id.tvItemUserName).text = user.name
        }
    }
}
