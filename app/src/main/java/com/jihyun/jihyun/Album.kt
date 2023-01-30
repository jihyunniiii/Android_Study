package com.jihyun.jihyun

import androidx.annotation.DrawableRes

data class Album(
    @DrawableRes val albumImage: Int,
    val albumName: String,
    val singerName: String
)
