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

class CatAdapter( private val catList : List<CatListApiItem>): RecyclerView.Adapter<CatHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CatHolder(layoutInflater.inflate(R.layout.itemcat, parent, false))
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        val item = catList[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = catList.size


}


