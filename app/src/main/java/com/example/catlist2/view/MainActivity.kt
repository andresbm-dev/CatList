package com.example.catlist2.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catlist2.DetailActivity
import com.example.catlist2.R
import com.example.catlist2.adapter.CatAdapter
import com.example.catlist2.model.APIService
import com.example.catlist2.model.CatListApiItem
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val recyclerVier:RecyclerView =findViewById(R.id.rvlist)



        var builder = OkHttpClient.Builder()
        builder.addInterceptor(Interceptor { chain ->
            val request: Request =
                chain.request().newBuilder().addHeader("x-api-key", "0277ef26-ef9c-4214-a3d0-de30c1d42114")
                    .build()
            chain.proceed(request)

        })


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
         val api = retrofit.create(APIService::class.java)
        api.getListCatsForBreeds().enqueue(object:Callback<List<CatListApiItem>>{
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
                    Toast.makeText(this@MainActivity,"La llamada se hizo con exito", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<List<CatListApiItem>>, t: Throwable) {

                //podriamos agregar un alertDialog
                Toast.makeText(this@MainActivity, "Se ha presentado un error con el servicio de datos " +
                        "de internet", Toast.LENGTH_SHORT).show()
            }

        })

    }

   /* private fun initRecyclerView() {
        itemcard.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("info", "info")
                putExtra("foto", "photo")
                putExtra("url", "URL")
            }
            startActivity(intent)
        }

    }*/


}