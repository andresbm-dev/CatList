package com.example.catlist2.view

import android.os.Bundle
import android.widget.Toast
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
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.toImmutableList
import retrofit2.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val catViewModel: CatListViewModel by viewModels()
    private lateinit var adapterrv: CatAdapter
    var page = 1
    val LIMIT = 4

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
            if (listcat != null)
            rv.adapter = CatAdapter(listcat, catViewModel)
        }

    }

    private fun callCatListViewModel() {
        //catViewModel.callCatListApi()
        catViewModel.getCatListApi(page)
        initReciclerView()
        val scroll = binding.scrollView
        val rv = binding.rvlist

        scroll?.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // on scroll change we are checking when users scroll as bottom.
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                page++
            //    getData(page, LIMIT)
                if (page>LIMIT){
                    Toast.makeText(this, "has llegado al final de los datos", Toast.LENGTH_SHORT).show()
                }else {
                    catViewModel.getCatListApi(page)
                    val rv = binding.rvlist
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)

                    catViewModel.catMListLD.observe(this) {
                        val cats = it.toImmutableList()
                        rv.adapter = CatAdapter(cats, catViewModel)
                    }

                }
                 //initReciclerView()
            }else if (scrollY == v.getChildAt(0).measuredHeight + v.measuredHeight) {
                page --
                catViewModel.getCatListApi(page)
                initReciclerView()
            }
        })
    }


/*
*  rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var scrollDy = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                page++
                catViewModel.getCatListApi(page)
                rv.layoutManager = LinearLayoutManager(this@MainActivity)

                catViewModel.catMListLD.observe(this@MainActivity) {
                    val cats = it.toImmutableList()

                    rv.adapter = adapterrv//CatAdapter(cats)

                }

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                scrollDy += dy
            }
        })*/

}

