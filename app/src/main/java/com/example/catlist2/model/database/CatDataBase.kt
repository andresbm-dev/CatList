package com.example.catlist2.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.catlist2.model.database.CatEntity


@Database(entities = [CatEntity::class] , version = 1)
abstract class CatDataBase :RoomDatabase(){

    abstract fun getCatsDao():CatDao

    companion object{
        private var instance :CatDataBase ?= null
        fun getDataBase(context: Context):CatDataBase{
            instance = instance ?: Room.databaseBuilder(context.applicationContext, CatDataBase::class.java, "catlist_table").build()
            return instance!!
        }

        fun destroyInstance(){
            instance = null
        }
    }
}