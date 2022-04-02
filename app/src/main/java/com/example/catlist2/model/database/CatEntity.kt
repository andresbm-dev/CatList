package com.example.catlist2.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.catlist2.model.CatListApiItem
import com.example.catlist2.model.Image

@Entity (tableName = "catlist_table")
data class CatEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "id_") val id_: Int = 0,
    @ColumnInfo (name = "name") val name: String,
  //  @ColumnInfo (name = "image") val image: Image,
    @ColumnInfo (name = "wikipedia_url") val wikipedia_url: String,
    @ColumnInfo (name = "description") val description: String,

    )

fun CatListApiItem.toDatabase() = CatEntity(name=name,
                                    wikipedia_url = wikipedia_url, description = description)
/*
    @ColumnInfo (name = "adaptability") val adaptability: Int,
    @ColumnInfo (name = "affection_level") val affection_level: Int,
    @ColumnInfo (name = "alt_names") val alt_names: String,
    @ColumnInfo (name = "bidability") val bidability: Int,
    @ColumnInfo (name = "cat_friendly") val cat_friendly: Int,
    @ColumnInfo (name = "cfa_url") val cfa_url: String,
    @ColumnInfo (name = "child_friendly") val child_friendly: Int,
    @ColumnInfo (name = "country_code") val country_code: String,
    @ColumnInfo (name = "country_codes") val country_codes: String,
    @ColumnInfo (name = "description") val description: String,
    @ColumnInfo (name = "dog_friendly") val dog_friendly: Int,
    @ColumnInfo (name = "energy_level") val energy_level: Int,
    @ColumnInfo (name = "experimental") val experimental: Int,
    @ColumnInfo (name = "grooming") val grooming: Int,
    @ColumnInfo (name = "hairless") val hairless: Int,
    @ColumnInfo (name = "health_issues") val health_issues: Int,
    @ColumnInfo (name = "hypoallergenic")val hypoallergenic: Int,
    @ColumnInfo (name = "id") val id: String,
    //@ColumnInfo (name = "image") val image: Image,
    @ColumnInfo (name = "indoor") val indoor: Int,
    @ColumnInfo (name = "intelligence") val intelligence: Int,
    @ColumnInfo (name = "lap") val lap: Int,
    @ColumnInfo (name = "life_span") val life_span: String,*/
   /* @ColumnInfo (name = "natural") val natural: Int,
    @ColumnInfo (name = "origin") val origin: String,
    @ColumnInfo (name = "rare") val rare: Int,
    @ColumnInfo (name = "reference_image_id") val reference_image_id: String,
    @ColumnInfo (name = "rex") val rex: Int,
    @ColumnInfo (name = "shedding_level") val shedding_level: Int,
    @ColumnInfo (name = "short_legs") val short_legs: Int,
    @ColumnInfo (name = "social_needs") val social_needs: Int,
    @ColumnInfo (name = "stranger_friendly") val stranger_friendly: Int,
    @ColumnInfo (name = "suppressed_tail") val suppressed_tail: Int,
    @ColumnInfo (name = "temperament") val temperament: String,
    @ColumnInfo (name = "vcahospitals_url") val vcahospitals_url: String,
    @ColumnInfo (name = "vetstreet_url") val vetstreet_url: String,
    @ColumnInfo (name = "vocalisation") val vocalisation: Int,
    //@ColumnInfo (name = "weight") val weight: Weight,
    @ColumnInfo (name = "wikipedia_url") val wikipedia_url: String
    )*/

