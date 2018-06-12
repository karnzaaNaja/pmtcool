package com.example.msi.cool.ui.customer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi.cool.R
import com.example.msi.cool.model.TypeCustomer
import com.example.msi.cool.ui.customer.holder.CustomerHolder

class AdapterCutomer(private var con: List<TypeCustomer>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<TypeCustomer>) {
        con = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CustomerHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = con.size

    override fun getItemViewType(position: Int): Int = R.layout.item_customer

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as CustomerHolder).onBind(con[position])



}