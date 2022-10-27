package com.example.win8.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win8.model.TermsModels
import com.example.win8.service.ApiInterface

class TermsRepository(private val apiInterface: ApiInterface) {
    private val termsLiveData = MutableLiveData<TermsModels>()
    val terms: LiveData<TermsModels>
    get() = termsLiveData

    suspend fun getTerms(){
        val result = apiInterface.getTerms()
        if(result.body()!= null){
            termsLiveData.postValue(result.body())
        }
    }
}