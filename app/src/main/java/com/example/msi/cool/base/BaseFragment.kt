package com.example.msi.cool.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<V : BaseContract.View, P : BaseContract.Presenter<V>> :
        Fragment(), BaseContract.View {

    protected abstract fun layoutToInflate(): Int

    protected abstract fun setup()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(layoutToInflate(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
}