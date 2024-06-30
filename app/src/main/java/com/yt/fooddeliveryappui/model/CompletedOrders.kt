package com.yt.fooddeliveryappui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Order(
    val items: List<Food>,
    val timestamp: Long = System.currentTimeMillis() // Use the current time as the default value
) : Parcelable
