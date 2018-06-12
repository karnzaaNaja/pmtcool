package com.example.msi.cool.ui.customer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.msi.cool.JsonMockUtility
import com.example.msi.cool.R
import com.example.msi.cool.model.ListDataCustomer
import com.example.msi.cool.model.TypeCustomer
import com.example.msi.cool.ui.customer.adapter.DetailAdapterCutomer
import com.example.msi.cool.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_show_customer.*

class ShowCustomer : AppCompatActivity() {

    companion object {
        const val Key = "KEY_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_customer)
        settype()
    }

    private fun settype(){
        val detail: TypeCustomer = intent.getParcelableExtra(DetailActivity.Key)
        when {
            detail.image.equals("1") -> {
                JsonMockUtility().apply {
                    val dataMock = getJsonToMock("customercentral.json", ListDataCustomer::class.java)
                    val food: DetailAdapterCutomer by lazy { DetailAdapterCutomer(listOf()) }
                    listTypeCustomer?.layoutManager = LinearLayoutManager(this@ShowCustomer, LinearLayoutManager.VERTICAL, false)
                    listTypeCustomer?.isNestedScrollingEnabled = false
                    listTypeCustomer?.adapter = food
                    dataMock.results?.let { food.setItem(it) }
                }
            }
            detail.image.equals("2") -> {
                JsonMockUtility().apply {
                    val dataMock = getJsonToMock("customerover.json", ListDataCustomer::class.java)
                    val food: DetailAdapterCutomer by lazy { DetailAdapterCutomer(listOf()) }
                    listTypeCustomer?.layoutManager = LinearLayoutManager(this@ShowCustomer, LinearLayoutManager.VERTICAL, false)
                    listTypeCustomer?.isNestedScrollingEnabled = false
                    listTypeCustomer?.adapter = food
                    dataMock.results?.let { food.setItem(it) }
                }
            }
            detail.image.equals("3") -> {
                JsonMockUtility().apply {
                    val dataMock = getJsonToMock("customeryi.json", ListDataCustomer::class.java)
                    val food: DetailAdapterCutomer by lazy { DetailAdapterCutomer(listOf()) }
                    listTypeCustomer?.layoutManager = LinearLayoutManager(this@ShowCustomer, LinearLayoutManager.VERTICAL, false)
                    listTypeCustomer?.isNestedScrollingEnabled = false
                    listTypeCustomer?.adapter = food
                    dataMock.results?.let { food.setItem(it) }
                }
            }
            else -> {
                JsonMockUtility().apply {
                    val dataMock = getJsonToMock("customereisan.json", ListDataCustomer::class.java)
                    val food: DetailAdapterCutomer by lazy { DetailAdapterCutomer(listOf()) }
                    listTypeCustomer?.layoutManager = LinearLayoutManager(this@ShowCustomer, LinearLayoutManager.VERTICAL, false)
                    listTypeCustomer?.isNestedScrollingEnabled = false
                    listTypeCustomer?.adapter = food
                    dataMock.results?.let { food.setItem(it) }
                }
            }
        }
    }

}
