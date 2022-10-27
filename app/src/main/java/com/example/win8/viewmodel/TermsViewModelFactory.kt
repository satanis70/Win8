package com.example.win8.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.win8.repository.TermsRepository

class TermsViewModelFactory(private val termsRepository: TermsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TermsViewModel(termsRepository) as T
    }
}