package com.example.androidapplicationtemplate.sample.data

import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
	private val postService: PostService,
) {

	suspend fun getPosts(): ArrayList<PostEntity> {
		return postService.getPosts()
	}

}