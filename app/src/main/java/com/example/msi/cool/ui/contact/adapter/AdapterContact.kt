package com.example.msi.cool.ui.contact.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi.cool.ui.contact.holder.ContactHolder
import com.example.msi.cool.R
import com.example.msi.cool.model.ContactModel

class AdapterContact(private var con: List<ContactModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<ContactModel>) {
        con = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ContactHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = con.size

    override fun getItemViewType(position: Int): Int = R.layout.item_contact_call

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ContactHolder).onBind(con[position])



}