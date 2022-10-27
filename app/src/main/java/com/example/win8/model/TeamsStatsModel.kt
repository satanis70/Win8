package com.example.win8.model


import com.google.gson.annotations.SerializedName

data class TeamsStatsModel(
    @SerializedName("teams_stats")
    val teamsStats: List<TeamsStat>
)