package com.example.catlist2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.catlist2.R
import com.example.catlist2.databinding.ActivityMainBinding
import com.example.catlist2.databinding.ItemcatBinding
import com.example.catlist2.model.CatListApiItem
import com.example.catlist2.viewModel.CatListViewModel
import javax.inject.Inject

class CatAdapter
@Inject constructor( private val catList : List<CatListApiItem>, private val catListViewModel: CatListViewModel)
    : RecyclerView.Adapter<CatHolder> (){

    private val listcat: MutableList<CatListApiItem> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CatHolder(layoutInflater.inflate(R.layout.itemcat, parent, false), catListViewModel )
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        val item = catList[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = catList.size

    fun updateData(newData: List<CatListApiItem>) {
        listcat.clear()
        listcat.addAll(newData)
        notifyDataSetChanged()
    }


}


