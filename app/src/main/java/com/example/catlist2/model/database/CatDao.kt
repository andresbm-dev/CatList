package com.example.catlist2.model.database

import androidx.room.*

//data access
@Dao
interface CatDao {

    @Query("SELECT * FROM catlist_table ORDER BY name DESC")
    suspend fun getAllCatFav():List<CatEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFavorite(cats : CatEntity)

    @Delete()
    suspend fun deleteFavorite( cats : List<CatEntity>)



}