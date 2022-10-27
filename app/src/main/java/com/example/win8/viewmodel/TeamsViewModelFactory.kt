package com.example.win8.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.win8.repository.TeamsRepository

class TeamsViewModelFactory(
    private val teamsRepository: TeamsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeamsViewModel(teamsRepository) as T
    }
}