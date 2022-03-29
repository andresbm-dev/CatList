package com.example.catlist2.viewModel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catlist2.R
import com.example.catlist2.adapter.CatAdapter
import com.example.catlist2.model.APIService
import com.example.catlist2.model.CatListApiItem
import com.example.catlist2.repository.CatListRepository
import com.example.catlist2.repository.CatPaginSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

import retrofit2.Retrofit

class CatListViewModel(private val apiService: APIService) : ViewModel() {


    private val catListMLD = MutableLiveData<List<CatListApiItem>>()
    val catListLD: LiveData<List<CatListApiItem>> get() =  catListMLD
    val isLoading = MutableLiveData<Boolean>()

    private val repository = CatListRepository( ) //Se crea instancia de repositorio



     fun getCatListApi(page:Int): MutableLiveData<List<CatListApiItem>>{

         viewModelScope.launch {
             isLoading.postValue(true)
             val result = repository.getallCat(page)
             if (result.isNotEmpty()) {
                 catListMLD.postValue(result)
             }
             println(result)
             println("el valor del mutable es $catListMLD")
             isLoading.postValue(false)
         }
         return catListMLD
    }

    fun getAllCats() : Flow<PagingData<CatListApiItem>> =Pager(
        config = PagingConfig(20, enablePlaceholders = false),){
                CatPaginSource(apiService)
        }.flow.cachedIn(viewModelScope)
}