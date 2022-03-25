package com.example.catlist2.repository

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catlist2.R
import com.example.catlist2.adapter.CatAdapter
import com.example.catlist2.model.APIService
import com.example.catlist2.model.CatListApiItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatListRepository {

    /*fun callCatListApi(): List<CatListApiItem>{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(APIService::class.java)
        api.getListCatsForBreeds().enqueue(object: Callback<List<CatListApiItem>> {
            override fun onResponse(
                call: Call<List<CatListApiItem>>,
                response: Response<List<CatListApiItem>>
            ) {
                val gaticos = response.body()
                val recyclerView  = findViewById<RecyclerView>(R.id.rvlist)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                if (call.isExecuted){
                    //show ReciclerView
                    recyclerView.adapter = gaticos?.let { CatAdapter(it) }
                    println(gaticos)
                    //initRecyclerView()
                    Toast.makeText(this,"La llamada se hizo con exito", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<List<CatListApiItem>>, t: Throwable) {

                //podriamos agregar un alertDialog
                Toast.makeText(this, "Se ha presentado un error con el servicio de datos " +
                        "de internet", Toast.LENGTH_SHORT).show()
            }

        })


    }*/
}