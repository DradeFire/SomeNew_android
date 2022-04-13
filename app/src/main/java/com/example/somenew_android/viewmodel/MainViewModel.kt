package com.example.somenew_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.somenew_android.api.model.NewModel
import com.example.somenew_android.api.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    val news: MutableLiveData<Response<NewModel>> = MutableLiveData()
    private val repository = Repository()

    fun getNews(){
        viewModelScope.launch {
            news.value = repository.postWeather()
        }
    }

}