package com.example.androidapplicationtemplate.sample.domain

import com.example.androidapplicationtemplate.sample.data.PostEntity
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
	private val repository: PostRepository,
) {

	suspend fun getPosts(): Result<ArrayList<PostEntity>> {
		return repository.getPosts()
	}

}