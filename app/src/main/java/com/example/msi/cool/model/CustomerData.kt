package com.example.msi.cool.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CustomerData(var size: String? = null, var detail: String? = null, var image: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(size)
        writeString(detail)
        writeString(image)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CustomerData> = object : Parcelable.Creator<CustomerData> {
            override fun createFromParcel(source: Parcel): CustomerData = CustomerData(source)
            override fun newArray(size: Int): Array<CustomerData?> = arrayOfNulls(size)
        }
    }
}

data class ListDataCustomer(@SerializedName("data") var results: List<CustomerData>? = null)