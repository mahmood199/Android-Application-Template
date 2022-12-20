package com.example.androidapplicationtemplate.sample.data

import retrofit2.http.GET

interface PostService {
	@GET("posts")
	suspend fun getPosts(): ArrayList<PostEntity>
}