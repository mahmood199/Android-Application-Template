package com.example.androidapplicationtemplate.sample.data

import com.example.androidapplicationtemplate.sample.domain.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
	private val remoteDataSource: PostRemoteDataSource
) : PostRepository {

	override suspend fun getPosts(): Result<ArrayList<PostEntity>> {
		return Result.success(remoteDataSource.getPosts())
	}

}