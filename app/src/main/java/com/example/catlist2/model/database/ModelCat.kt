package com.example.catlist2.model.database

import com.example.catlist2.model.CatListApiItem
import com.example.catlist2.model.Image

data class ModelCat (val name: String,
                     val image: Image,
                     val wikipedia_url: String,
                     val description: String,
)
fun CatListApiItem.toDomain()=ModelCat(name, image, wikipedia_url, description)
