package com.example.catlist2.repository

import com.example.catlist2.RetrofitHelper
import com.example.catlist2.model.APIService
import com.example.catlist2.model.CatListApiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class CatService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCat(page:Int):List<CatListApiItem>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(APIService::class.java).getListCatsForBreeds(0,page,5)
            println(response.body())
            response.body()?: emptyList()
        }
    }

}