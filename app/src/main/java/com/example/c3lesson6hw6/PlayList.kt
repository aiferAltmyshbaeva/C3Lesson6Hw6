package com.example.c3lesson6hw6

import java.io.Serializable

data class PlayList(
    val indexNumber: Int? = 0,
    val songTitle: String? = "Unknown Song",
    val singer: String? = "Unknown Singer",
    val songLength: String? = "Uknown Length"
) : Serializable
