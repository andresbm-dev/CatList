package com.example.catlist2.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catlist2.adapter.CatAdapter
import com.example.catlist2.databinding.ActivityMainBinding
import com.example.catlist2.viewModel.CatListViewModel
import retrofit2.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val catViewModel: CatListViewModel by viewModels()
    var page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)
        callCatListViewModel()
        catViewModel.isLoading.observe(this, Observer {
            binding.progressBar?.isVisible = it
        })

            }

     fun initReciclerView() {

        val rv = binding.rvlist
        rv.layoutManager = LinearLayoutManager(this@MainActivity)

        catViewModel.catListLD.observe(this) { listcat ->
            rv.adapter = CatAdapter(listcat)
        }

/*        rv.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })*/




    }



    private fun callCatListViewModel() {
        //catViewModel.callCatListApi()
        catViewModel.getCatListApi(page)
        initReciclerView()
        val scroll = binding.scrollView
        scroll?.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // on scroll change we are checking when users scroll as bottom.
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                page++
                catViewModel.getCatListApi(page)
                initReciclerView()
            }
        })


    }



}

