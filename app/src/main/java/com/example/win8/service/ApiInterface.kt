package com.example.win8.service

import com.example.win8.model.TeamsStatsModel
import com.example.win8.model.TermsModels
import com.example.win8.model.TopPlayersModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/win8/terminology.json")
    suspend fun getTerms(): Response<TermsModels>
    @GET("/win8/teams_stats.json")
    suspend fun getTeams(): Response<TeamsStatsModel>
    @GET("/win8/top_players.json")
    suspend fun getPlayers(): Response<TopPlayersModel>
}