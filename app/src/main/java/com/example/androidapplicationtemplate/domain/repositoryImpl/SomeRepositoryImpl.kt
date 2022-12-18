package com.example.androidapplicationtemplate.domain.repositoryImpl

import com.example.androidapplicationtemplate.data.repository.SomeRepository

class SomeRepositoryImpl: SomeRepository {
	override suspend fun someCrudOperation(): Result<String> {
		return Result.success("Sucess")
	}
}