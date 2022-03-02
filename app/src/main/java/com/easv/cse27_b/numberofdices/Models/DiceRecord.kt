package com.easv.cse27_b.numberofdices.Models

import android.os.Parcel
import android.os.Parcelable

class DiceRecord(val score: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DiceRecord> {
        override fun createFromParcel(parcel: Parcel): DiceRecord {
            return DiceRecord(parcel)
        }

        override fun newArray(size: Int): Array<DiceRecord?> {
            return arrayOfNulls(size)
        }
    }
}