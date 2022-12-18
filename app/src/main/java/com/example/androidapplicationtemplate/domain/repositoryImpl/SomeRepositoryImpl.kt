package com.example.androidapplicationtemplate.domain.repositoryImpl

import com.example.androidapplicationtemplate.data.local.localDataSource.SomeLocalDataSource
import com.example.androidapplicationtemplate.data.remote.remoteDataSource.SomeRemoteDataSource
import com.example.androidapplicationtemplate.data.repository.SomeRepository
import javax.inject.Inject

class SomeRepositoryImpl @Inject constructor(
	localDataSource: SomeLocalDataSource,
	remoteDataSource: SomeRemoteDataSource
) : SomeRepository {
	override suspend fun someCrudOperation(): Result<String> {
		return Result.success("Sucess")
	}
}