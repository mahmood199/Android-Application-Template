package com.example.androidapplicationtemplate.sample

import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
	private val repository: PostRepository,
) {

	suspend fun getPosts(): Result<ArrayList<PostEntity>> {
		return repository.getPosts()
	}

}