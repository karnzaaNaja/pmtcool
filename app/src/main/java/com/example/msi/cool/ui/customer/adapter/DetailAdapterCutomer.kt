package com.example.msi.cool.ui.customer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi.cool.R
import com.example.msi.cool.model.CustomerData
import com.example.msi.cool.ui.customer.holder.CustomerHolderData

class DetailAdapterCutomer(private var con: List<CustomerData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    fun setItem(items: List<CustomerData>) {
        con = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CustomerHolderData(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = con.size

    override fun getItemViewType(position: Int): Int = R.layout.item_detail_customer

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as CustomerHolderData).onBind(con[position])
}