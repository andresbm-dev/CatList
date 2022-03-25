package com.example.catlist2.viewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

class CatListViewModel : ViewModel() {

    val catListMLD = MutableLiveData<CatListApiItem>()

}