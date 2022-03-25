package com.example.catlist2.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {
    //'api_key=0277ef26-ef9c-4214-a3d0-de30c1d42114'
    @Headers("x-api-key: " + "0277ef26-ef9c-4214-a3d0-de30c1d42114")
    @GET(".")
     fun getListCatsForBreeds() : Call<List<CatListApiItem>>
}

//https://api.thecatapi.com/v1/breeds&api_Key=0277ef26-ef9c-4214-a3d0-de30c1d42114