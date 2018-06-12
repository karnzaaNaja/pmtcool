package com.example.msi.cool.ui.detail.holder


import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi.cool.extension.load
import com.example.msi.cool.model.ReviewBitzer
import kotlinx.android.synthetic.main.item_re_view.view.*

class ReviewBitzerHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(cheft: ReviewBitzer) {

        itemView.apply {
            imageReView.load(cheft.image)
            name.text=cheft.name
            comment.text=cheft.review
        }

    }
}