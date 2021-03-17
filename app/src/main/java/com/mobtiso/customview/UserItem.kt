package com.mobtiso.customview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserItem(
    val userName: String,
    val password: String
) : Parcelable