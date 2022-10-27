package com.example.win8.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win8.model.TeamsStatsModel
import com.example.win8.repository.TeamsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeamsViewModel(private val teamsRepository: TeamsRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            teamsRepository.getTeams()
        }
    }
    val teams: LiveData<TeamsStatsModel>
    get() = teamsRepository.teams
}