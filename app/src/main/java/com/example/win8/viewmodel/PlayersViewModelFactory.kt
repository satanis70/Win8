package com.example.win8.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.win8.repository.PlayersRepository

class PlayersViewModelFactory(
    private val playersRepository: PlayersRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlayersViewModel(playersRepository) as T
    }
}