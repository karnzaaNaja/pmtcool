package com.example.msi.cool.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PmtCoolModel(val size: String? = null,
                     val type: String? = null,
                     val detail: String? = null,
                     val image: String? = null,
                     val ingredients: String? = null,
                     val vote: String? = null,
                     val gallery: ImageCover? = null,
                     val recipe: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readParcelable<ImageCover>(ImageCover::class.java.classLoader),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(size)
        writeString(type)
        writeString(detail)
        writeString(image)
        writeString(ingredients)
        writeString(vote)
        writeParcelable(gallery, 0)
        writeString(recipe)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PmtCoolModel> = object : Parcelable.Creator<PmtCoolModel> {
            override fun createFromParcel(source: Parcel): PmtCoolModel = PmtCoolModel(source)
            override fun newArray(size: Int): Array<PmtCoolModel?> = arrayOfNulls(size)
        }
    }
}

data class ListPmtCool(@SerializedName("data") var results: List<PmtCoolModel>? = null)