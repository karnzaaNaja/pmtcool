package com.example.msi.cool.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TypeCustomer(var type: String? = null,
    var call: String? = null,
    var image: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(type)
        writeString(call)
        writeString(image)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TypeCustomer> = object : Parcelable.Creator<TypeCustomer> {
            override fun createFromParcel(source: Parcel): TypeCustomer = TypeCustomer(source)
            override fun newArray(size: Int): Array<TypeCustomer?> = arrayOfNulls(size)
        }
    }
}

data class ListTypeCustomer(@SerializedName("data") var results: List<TypeCustomer>? = null)

