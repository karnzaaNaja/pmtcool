package com.example.msi.cool.ui.customer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msi.cool.ui.home.HomeContact
import com.example.msi.cool.JsonMockUtility
import com.example.msi.cool.R
import com.example.msi.cool.model.ListTypeCustomer
import com.example.msi.cool.ui.customer.adapter.AdapterCutomer
import kotlinx.android.synthetic.main.layout_customer.*

class CustomerFragment : Fragment(), HomeContact.View {

    private lateinit var presenter: HomeContact.Presenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater!!.inflate(R.layout.layout_customer, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setJsonMock()
    }

    private fun  setJsonMock(){
        JsonMockUtility().apply {
            val dataMock = getJsonToMock("customer.json", ListTypeCustomer::class.java)
            val food: AdapterCutomer by lazy { AdapterCutomer(listOf()) }
            listType?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            listType?.isNestedScrollingEnabled = false
            listType?.adapter = food
            dataMock.results?.let { food.setItem(it) }
        }
    }





}
