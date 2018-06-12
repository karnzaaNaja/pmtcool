package com.example.msi.karn.ui.detail.viewpager

import android.annotation.SuppressLint
import com.example.msi.cool.base.BaseFragment
import com.example.msi.cool.R
import com.example.msi.cool.extension.load
import com.example.msigl62.coworkandroiduset.PresenterMain
import kotlinx.android.synthetic.main.pager_theme.*


@SuppressLint("ValidFragment")
class ImagePagerFive(imageGalleryFive: String) : BaseFragment<ContractMain.View, PresenterMain>() {

    var url: String = imageGalleryFive

    override fun showProgressDialog() {}

    override fun layoutToInflate(): Int = R.layout.pager_theme

    override fun setup() { imagePager.load(url) }
}