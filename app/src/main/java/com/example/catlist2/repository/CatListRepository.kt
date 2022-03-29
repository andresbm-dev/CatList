package com.example.catlist2.repository

import com.example.catlist2.model.CatListApiItem

class CatListRepository {

    private val api = CatService()
    suspend fun getallCat(page :Int):List<CatListApiItem>{
        val response = api.getCat(page)
        return response
    }


}