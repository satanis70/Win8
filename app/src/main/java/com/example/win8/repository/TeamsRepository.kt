package com.example.win8.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win8.model.TeamsStatsModel
import com.example.win8.service.ApiInterface

class TeamsRepository(private val apiInterface: ApiInterface) {
    private val teamsLiveData = MutableLiveData<TeamsStatsModel>()
    val teams: LiveData<TeamsStatsModel>
    get() = teamsLiveData

    suspend fun getTeams(){
        val result = apiInterface.getTeams()
        if (result.body()!=null){
            teamsLiveData.postValue(result.body())
        }
    }
}