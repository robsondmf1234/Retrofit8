package com.example.retrofittutorial8.repository

import com.example.retrofittutorial8.api.RetrofitInstance
import com.example.retrofittutorial8.model.Post
import retrofit2.Call
import retrofit2.Response

class Repository {
    suspend fun getPost(): Call<Post> {
        return RetrofitInstance.api.getPost()
    }
}