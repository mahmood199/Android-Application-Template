package com.example.androidapplicationtemplate.sample

import retrofit2.http.GET

interface PostService {
	@GET("posts")
	suspend fun getPosts(): ArrayList<PostEntity>
}