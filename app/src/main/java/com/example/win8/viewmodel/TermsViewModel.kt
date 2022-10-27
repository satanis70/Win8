package com.example.win8.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win8.model.TermsModels
import com.example.win8.repository.TermsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TermsViewModel(private val termsRepository: TermsRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            termsRepository.getTerms()
        }
    }
    val terms : LiveData<TermsModels>
    get() = termsRepository.terms
}