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
import com.example.catlist2.model.database.CatEntity
import com.example.catlist2.repository.CatListRepository
import com.example.catlist2.repository.CatPaginSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class CatListViewModel
    @Inject constructor (private val repository : CatListRepository): ViewModel() {

    private val catListMLD = MutableLiveData<List<CatListApiItem>>()
    val catListLD: LiveData<List<CatListApiItem>> get() =  catListMLD
    val isLoading = MutableLiveData<Boolean>()

    private var catMutable = mutableListOf<CatListApiItem>()
    private var catMlistLD_ = MutableLiveData<MutableList<CatListApiItem>>()
    val catMListLD :LiveData<MutableList<CatListApiItem>> get() = catMlistLD_
    //private val repository = CatListRepository()

    //Se crea instancia de repositorio

     fun getCatListApi(page:Int): MutableLiveData<List<CatListApiItem>>{

         viewModelScope.launch {
             isLoading.postValue(true)
             val result = repository.getallCat(page)
             if (result.isNotEmpty()) {
                 catListMLD.postValue(result)
                 catMutable.addAll(result)
                 catMlistLD_.postValue(catMutable)

             }
             println(result)
             println("el valor del mutable es $catListMLD")
             isLoading.postValue(false)
         }
         return catListMLD
    }

   fun insertAllFavorite(cat:CatListApiItem){
       viewModelScope.launch {
           repository.insertAllFavorite(cat)
       }

   }
}