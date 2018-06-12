package com.example.msi.cool.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ImageCover(@SerializedName("image_cover1") var image_cover1: String? = null,
                      @SerializedName("image_cover2") var image_cover2: String? = null,
                      @SerializedName("image_cover3") var image_cover3: String? = null,
                      @SerializedName("image_cover4") var image_cover4: String? = null,
                      @SerializedName("image_cover5") var image_cover5: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(image_cover1)
        writeString(image_cover2)
        writeString(image_cover3)
        writeString(image_cover4)
        writeString(image_cover5)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ImageCover> = object : Parcelable.Creator<ImageCover> {
            override fun createFromParcel(source: Parcel): ImageCover = ImageCover(source)
            override fun newArray(size: Int): Array<ImageCover?> = arrayOfNulls(size)
        }
    }
}