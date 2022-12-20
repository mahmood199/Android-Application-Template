package com.example.androidapplicationtemplate.sample

interface PostRepository {
	suspend fun getPosts(): Result<ArrayList<PostEntity>>
}