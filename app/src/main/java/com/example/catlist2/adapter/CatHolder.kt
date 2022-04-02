package com.example.catlist2.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivities
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.catlist2.DetailActivity
import com.example.catlist2.R
import com.example.catlist2.model.APIService
import com.example.catlist2.model.CatListApiItem
import com.example.catlist2.model.database.CatDao
import com.example.catlist2.model.database.CatEntity
import com.example.catlist2.model.database.toDatabase
import com.example.catlist2.repository.CatListRepository
import com.example.catlist2.repository.CatService
import com.example.catlist2.viewModel.CatListViewModel
import javax.inject.Inject


class CatHolder
@Inject constructor (private val view: View, private val catListViewModel: CatListViewModel):
    RecyclerView.ViewHolder(view)  {

    val name = view.findViewById<TextView>(R.id.tvNameCat)
    val btnFav_ = view.findViewById<ImageButton>(R.id.ibVoidfav)
    val btnFav =  view.findViewById<ImageButton>(R.id.ibfav)
    val statusF_ = MutableLiveData<Boolean>()
    val status_ = MutableLiveData<Boolean>()

    lateinit var catDao: CatDao


    lateinit var informacion : String
    lateinit var url :String
    lateinit var photo: String
    fun bind(catlist : CatListApiItem){
       catlist.name.let{name.text = catlist.name}
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
        btnFav_.setOnClickListener {
            //sin favorito//agregar funcion para añadir a favoritos
            status_.postValue(false)


            catListViewModel.insertAllFavorite(catlist)

            //favoritCats.add()
            it.isVisible =false

            btnFav.isVisible = true
        }
        btnFav.setOnClickListener{
            //agregar funcion para eliminar favorito

            it.isVisible = false
            btnFav_.isVisible = true
        }


    }





}
