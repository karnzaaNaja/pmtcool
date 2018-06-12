package com.example.msi.cool.ui.customer.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi.cool.extension.load
import com.example.msi.cool.model.CustomerData
import kotlinx.android.synthetic.main.item_detail_customer.view.*

class CustomerHolderData(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(pmt: CustomerData) {
        itemView.apply {
            imCustomer.load(pmt.image)
            textSize.text=pmt.size
            textDetail.text=pmt.detail
        }
    }
}