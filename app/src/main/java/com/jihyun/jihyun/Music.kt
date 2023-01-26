package com.jihyun.jihyun

import androidx.annotation.DrawableRes

data class Music(
    @DrawableRes val image: Int,
    val musicName: String,
    val singerName: String
)
