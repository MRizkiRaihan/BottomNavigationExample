package com.mrizkiraihan.bottomnavigationexample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

class Movie(
    var imageMovie: Int,
    var titleMovie: String,
    var descMovie: String
    ): Parcelable
