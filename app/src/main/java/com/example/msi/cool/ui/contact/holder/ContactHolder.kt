package com.example.msi.cool.ui.contact.holder

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi.cool.model.ContactModel
import kotlinx.android.synthetic.main.item_contact_call.view.*


class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(pmt: ContactModel) {
        itemView.apply {
            nameType.text= pmt.type.toString()
            detailCon.text=pmt.call
           // image.load(pmt.image)
            layoutContact.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", pmt.call, null))
                itemView.context.startActivity(intent)

            }

        }
    }


}