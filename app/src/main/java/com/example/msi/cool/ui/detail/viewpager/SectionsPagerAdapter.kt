package com.example.msi.karn.ui.detail.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager, imageGalleryOne: String,
                           imageGalleryTwo: String,
                           imageGalleryThree: String,
                           imageGalleryFour: String,
                           imageGalleryFive: String) : FragmentPagerAdapter(fm) {
    private var urlImageOne: String = imageGalleryOne
    private var urlImageTwo: String = imageGalleryTwo
    private var urlImageThree: String = imageGalleryThree
    private var urlImageFour: String = imageGalleryFour
    private var urlImageFive: String = imageGalleryFive
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> ImagePagerOne(urlImageOne)
        1 -> ImagePagerTwo(urlImageTwo)
        2 -> ImagePagerThree(urlImageThree)
        3 -> ImagePagerFour(urlImageFour)
        else -> ImagePagerFive(urlImageFive)
    }

    override fun getCount(): Int = 5
}