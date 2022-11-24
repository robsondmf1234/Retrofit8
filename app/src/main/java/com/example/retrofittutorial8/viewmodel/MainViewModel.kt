package com.example.retrofittutorial8.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittutorial8.model.Post
import com.example.retrofittutorial8.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()

            myResponse.value = response
        }
    }

}