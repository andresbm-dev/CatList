package com.example.catlist2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catlist2.model.APIService

class PaginViewModelFactory(private val apiService: APIService):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PaginViewModel::class.java)){
            return PaginViewModel(apiService) as T
        }
        throw IllegalArgumentException("not found view model")
    }
}