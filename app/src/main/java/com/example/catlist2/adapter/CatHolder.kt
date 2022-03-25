package com.example.catlist2.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivities
import androidx.recyclerview.widget.RecyclerView
import com.example.catlist2.DetailActivity
import com.example.catlist2.R
import com.example.catlist2.model.CatListApiItem

class CatHolder(private  val view: View): RecyclerView.ViewHolder(view)  {

    val name = view.findViewById<TextView>(R.id.tvNameCat)
    lateinit var informacion : String
    lateinit var url :String
    lateinit var photo: String
    fun bind(catlist : CatListApiItem){
        name.text = catlist.name
        informacion = catlist.description
        url = catlist.wikipedia_url
        photo = catlist.image.url
        name.setOnClickListener {
            val intent = Intent(view.context, DetailActivity::class.java).apply {
                putExtra("NAME", "${name.text}")
                putExtra("INFORMACION", informacion)
                putExtra("URL", url)
                putExtra("PHOTO", photo)

            }
            startActivities(view.context, arrayOf(intent), Bundle.EMPTY)
        }
    }
}