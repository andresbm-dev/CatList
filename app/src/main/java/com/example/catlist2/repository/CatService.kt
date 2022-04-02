package com.example.catlist2.repository

import com.example.catlist2.RetrofitHelper
import com.example.catlist2.model.APIService
import com.example.catlist2.model.CatListApiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class CatService @Inject constructor(private val apiService: APIService) {

    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCat(page:Int):List<CatListApiItem>{
        return withContext(Dispatchers.IO){
            val response = apiService.getListCatsForBreeds(0,page,6)
            println(response.body())
            response.body()?: emptyList()
        }
    }

}