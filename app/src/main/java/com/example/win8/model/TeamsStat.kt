package com.example.win8.model


import com.google.gson.annotations.SerializedName

data class TeamsStat(
    val gp: String,
    val img: String,
    @SerializedName("L")
    val l: String,
    val name: String,
    val rank: String,
    val w: String
)