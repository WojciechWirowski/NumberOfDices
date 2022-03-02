package com.easv.cse27_b.numberofdices.Models

import android.os.Parcel
import android.os.Parcelable
import java.util.jar.Attributes

class History(var name: String?, val list: ArrayList<Int>): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        arrayListOf<Int>().apply { parcel.readArrayList(Int::class.java.classLoader) }
        //parcel.readArrayList(Int::class.java.classLoader) as ArrayList<Int>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeIntArray(list.toIntArray())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<History> {
        override fun createFromParcel(parcel: Parcel): History {
            return History(parcel)
        }

        override fun newArray(size: Int): Array<History?> {
            return arrayOfNulls(size)
        }
    }
}