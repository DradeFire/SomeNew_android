package com.example.somenew_android.api.retrofit

import com.example.somenew_android.api.model.NewModel
import com.example.somenew_android.consts.Consts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi{

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q: String = "apple",
        @Query("from") from: String = "2022-04-12",
        @Query("to") to: String = "2022-04-12",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Consts.API_KEY
    ): Response<NewModel>
}