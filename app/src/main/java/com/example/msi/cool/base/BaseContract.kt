package com.example.msi.cool.base

open class BaseContract {

    interface View {
        fun showProgressDialog()
    }

    interface Presenter<V : View> {
        fun onViewCreate()
        fun onViewDestroy()
        fun onViewStart()
        fun onViewStop()
    }
}