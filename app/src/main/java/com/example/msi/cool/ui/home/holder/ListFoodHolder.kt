package com.example.msi.cool.ui.home.holder


import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi.cool.ui.detail.DetailActivity
import com.example.msi.cool.extension.load
import com.example.msi.cool.model.PmtCoolModel
import kotlinx.android.synthetic.main.item_theme_home.view.*

class ListFoodHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(pmt:PmtCoolModel ) {

        itemView.apply {
            imageFood.load(pmt.image)
            foodName.text = pmt.size
            imageFood.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, DetailActivity::class.java)
                    .putExtra(DetailActivity.Key, pmt))
            }
        }


    }
}