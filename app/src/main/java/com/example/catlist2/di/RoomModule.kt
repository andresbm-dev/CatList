package com.example.catlist2.di

import android.content.Context
import androidx.room.Room
import com.example.catlist2.model.database.CatDataBase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val CAT_DATA_BASE = "catlist_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CatDataBase::class.java, CAT_DATA_BASE).build()

    @Singleton
    @Provides
    fun providesCatDao (dataBase: CatDataBase) = dataBase.getCatsDao()
}