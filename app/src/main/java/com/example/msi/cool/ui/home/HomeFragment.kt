package com.example.msi.cool.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.msi.karn.ui.home.adapter.AdapterList
import com.example.msi.cool.JsonMockUtility
import com.example.msi.cool.MapsActivity
import com.example.msi.cool.R
import com.example.msi.cool.extension.load
import com.example.msi.cool.model.ListPmtCool
import kotlinx.android.synthetic.main.layout_menu_home.*
import kotlinx.android.synthetic.main.layout_tool_bar_main.*

class HomeFragment : Fragment(), HomeContact.View {

    private lateinit var presenter: HomeContact.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater!!.inflate(R.layout.layout_menu_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setJsonMock()
        setToolBar()
        setNew()
    }

    private fun setNew(){
        imNews.load("https://scontent.fbkk6-2.fna.fbcdn.net/v/t1.0-9/34701799_597916837257407_6534097059241263104_n.jpg?_nc_cat=0&oh=59cac2f0a8dd154f6c49c19d8e114c86&oe=5B78D2D5")
        imNews.setOnClickListener {
            val i = Intent(context, NewActivity::class.java)
            startActivity(i)
        }

    }


    private fun setToolBar(){
        com.setOnClickListener {
            val i = Intent(context, MapsActivity::class.java)
            startActivity(i)
        }
        textMap.setOnClickListener {
            val i = Intent(context, MapsActivity::class.java)
            startActivity(i)
        }
    }

    private fun setJsonMock() {
        JsonMockUtility().apply {
            val dataMock = getJsonToMock("pmtbit.json", ListPmtCool::class.java)
            val food: AdapterList by lazy { AdapterList(listOf()) }
            listPmtPop?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            listPmtPop?.isNestedScrollingEnabled = false
            listPmtPop?.adapter = food
            dataMock.results?.let { food.setItem(it) }
        }

        JsonMockUtility().apply {
            val dataMock = getJsonToMock("pmteco.json", ListPmtCool::class.java)
            val food: AdapterList by lazy { AdapterList(listOf()) }
            listPmtMain?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            listPmtMain?.isNestedScrollingEnabled = false
            listPmtMain?.adapter = food
            dataMock.results?.let { food.setItem(it) }
        }

        JsonMockUtility().apply {
            val dataMock = getJsonToMock("pmtair.json", ListPmtCool::class.java)
            val food: AdapterList by lazy { AdapterList(listOf()) }
            listPmtnew?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            listPmtnew?.isNestedScrollingEnabled = false
            listPmtnew?.adapter = food
            dataMock.results?.let { food.setItem(it) }
        }
    }

}
