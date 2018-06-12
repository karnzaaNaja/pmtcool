package com.example.msi.cool.ui.customer.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi.cool.model.TypeCustomer
import com.example.msi.cool.ui.customer.ShowCustomer
import kotlinx.android.synthetic.main.item_contact_call.view.*


class CustomerHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(pmt: TypeCustomer) {
        itemView.apply {
            nameType.text= pmt.type.toString()
            detailCon.text=pmt.call
            itemView.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, ShowCustomer::class.java)
                    .putExtra(ShowCustomer.Key, pmt))
            }

        }
    }

}