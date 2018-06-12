package com.example.msi.cool.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ReviewBitzer(val name: String? = null,
    val image: String? = null,
    val review: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(image)
        writeString(review)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ReviewBitzer> = object : Parcelable.Creator<ReviewBitzer> {
            override fun createFromParcel(source: Parcel): ReviewBitzer = ReviewBitzer(source)
            override fun newArray(size: Int): Array<ReviewBitzer?> = arrayOfNulls(size)
        }
    }
}

data class ListReview(@SerializedName("data") var results: List<ReviewBitzer>? = null)