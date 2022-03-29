package com.example.catlist2.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.catlist2.RetrofitHelper
import com.example.catlist2.model.APIService
import com.example.catlist2.model.CatListApiItem
import retrofit2.HttpException
import java.io.IOException

class CatPaginSource(private val apiService: APIService): PagingSource<Int, CatListApiItem>() {

    override fun getRefreshKey(state: PagingState<Int, CatListApiItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatListApiItem> {

        val page = params.key ?: 1
        return  try {

            val response= apiService.getCatsForBreeds_(0, page, params.loadSize)
            LoadResult.Page(
                response, prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        }
        catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }

    }
}