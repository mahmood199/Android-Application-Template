package com.example.androidapplicationtemplate.data.repository

import com.example.androidapplicationtemplate.data.local.localDataSource.SomeLocalDataSource
import com.example.androidapplicationtemplate.data.remote.remoteDataSource.SomeRemoteDataSource

class SomeRepository(
	val localDataSource: SomeLocalDataSource,
	val remoteDataSource: SomeRemoteDataSource,
)