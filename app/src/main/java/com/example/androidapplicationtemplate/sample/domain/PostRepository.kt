package com.example.androidapplicationtemplate.sample.domain

import com.example.androidapplicationtemplate.sample.data.PostEntity

interface PostRepository {
	suspend fun getPosts(): Result<ArrayList<PostEntity>>
}