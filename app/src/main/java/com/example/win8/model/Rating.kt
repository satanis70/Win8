package com.example.win8.model


import com.google.gson.annotations.SerializedName

data class Rating(
    val age: String,
    val img: String,
    @SerializedName("NHLRating")
    val nHLRating: String,
    val name: String,
    val playerstyle: String,
    val rank: String,
    val team: String
)