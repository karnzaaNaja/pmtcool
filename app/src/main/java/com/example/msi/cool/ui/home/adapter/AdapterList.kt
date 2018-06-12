package com.example.msi.karn.ui.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi.cool.ui.home.holder.ListFoodHolder
import com.example.msi.cool.R
import com.example.msi.cool.model.PmtCoolModel

class AdapterList(private var coWork: List<PmtCoolModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<PmtCoolModel>) {
        coWork = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ListFoodHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = coWork.size

    override fun getItemViewType(position: Int): Int = R.layout.item_theme_home

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ListFoodHolder).onBind(coWork[position])



}