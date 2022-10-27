package com.example.win8.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win8.model.TopPlayersModel
import com.example.win8.repository.PlayersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(private val playersRepository: PlayersRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            playersRepository.getPlayers()
        }
    }
    val players: LiveData<TopPlayersModel>
    get() = playersRepository.players
}