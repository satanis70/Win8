package com.example.win8.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win8.model.TopPlayersModel
import com.example.win8.service.ApiInterface

class PlayersRepository(private val apiInterface: ApiInterface) {
    private val playersLiveData = MutableLiveData<TopPlayersModel>()
    val players: LiveData<TopPlayersModel>
        get() = playersLiveData

    suspend fun getPlayers() {
        val result = apiInterface.getPlayers()
        if (result.body() != null) {
            playersLiveData.postValue(result.body())
        }
    }
}