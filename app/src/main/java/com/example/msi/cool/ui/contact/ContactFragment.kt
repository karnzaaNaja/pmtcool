package com.example.msi.cool.ui.contact

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msi.cool.JsonMockUtility
import com.example.msi.cool.R
import com.example.msi.cool.model.ListContact
import com.example.msi.cool.ui.contact.adapter.AdapterContact
import com.example.msi.cool.ui.home.HomeContact
import kotlinx.android.synthetic.main.layout_contact.*

class ContactFragment : Fragment(), HomeContact.View  {

    private lateinit var presenter: HomeContact.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater!!.inflate(R.layout.layout_contact, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        JsonMockUtility().apply {
            val dataMock = getJsonToMock("contact.json", ListContact::class.java)
            val con: AdapterContact by lazy { AdapterContact(listOf()) }
            listCon?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            listCon?.isNestedScrollingEnabled = false
            listCon?.adapter = con
            dataMock.results?.let { con.setItem(it) }
        }


    }



}
