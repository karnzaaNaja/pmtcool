package com.example.msi.cool.base

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    override fun onViewCreate() {}

    override fun onViewStart() {}

    override fun onViewDestroy() {}

    override fun onViewStop() {}
}