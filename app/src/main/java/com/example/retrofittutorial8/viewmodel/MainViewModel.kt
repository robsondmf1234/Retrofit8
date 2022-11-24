package com.example.retrofittutorial8.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittutorial8.model.Post
import com.example.retrofittutorial8.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun getPost() {
        viewModelScope.launch {
            val call = repository.getPost()
            call.enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    if (response.isSuccessful){
                        myResponse.value = response
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    t.message?.let { Log.d("Response", it) }
                }
            })
        }
    }

}