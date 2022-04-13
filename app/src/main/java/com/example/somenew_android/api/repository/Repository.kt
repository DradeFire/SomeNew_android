package com.example.somenew_android.api.repository

import com.example.somenew_android.api.model.NewModel
import com.example.somenew_android.api.retrofit.RetrofitInstanceApi
import retrofit2.Response

class Repository {

    suspend fun postWeather(): Response<NewModel> {
        return RetrofitInstanceApi.apiNews.getNews()
    }

}