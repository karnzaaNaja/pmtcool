package com.example.msi.cool.ui.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi.cool.R
import com.example.msi.cool.model.ReviewBitzer
import com.example.msi.cool.ui.detail.holder.ReviewBitzerHolder

class AdpterReview (private var bit: List<ReviewBitzer>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<ReviewBitzer>) {
        bit = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ReviewBitzerHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = bit.size

    override fun getItemViewType(position: Int): Int = R.layout.item_re_view

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as  ReviewBitzerHolder).onBind(bit[position])



}