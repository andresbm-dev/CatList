package com.example.catlist2.repository

import com.example.catlist2.model.CatListApiItem
import com.example.catlist2.model.database.*
import javax.inject.Inject

class CatListRepository @Inject constructor( private val api: CatService, private val catDao: CatDao)
{

    //   private val api = CatService()

    suspend fun getallCat(page :Int):List<CatListApiItem>{
        val response = api.getCat(page)
        return response
    }

    suspend fun insertAllFavorite(cat:CatListApiItem) {
        val response = cat.toDatabase()
        catDao.insertAllFavorite(response)
    }
    /*suspend fun getallCat(page :Int):List<CatListApiItem>{
        val response = api.getCat(page)
        return response
    }*/
    /*suspend fun getFavorite():List<CatListApiItem>{
        val response = catDao.getAllCatFav().map { it.toDomain() }
        return response
    }*/



}