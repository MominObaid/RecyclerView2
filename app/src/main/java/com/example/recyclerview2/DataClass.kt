package com.example.recyclerview2
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class itemList(
    var Title: String,
    var Description: String,
    var checked: Boolean
    ) : Parcelable {
    constructor() : this ("", "",  false )
}