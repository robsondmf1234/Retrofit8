package com.example.retrofittutorial8.api

import com.example.retrofittutorial8.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

}