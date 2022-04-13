package com.example.somenew_android.api.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceApi{

    private val retrofitNews by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiNews: RetrofitApi by lazy {
        retrofitNews.create(RetrofitApi::class.java)
    }

}