package com.example.androidapplicationtemplate.core.di

import com.example.androidapplicationtemplate.data.local.localDataSource.SomeLocalDataSource
import com.example.androidapplicationtemplate.data.remote.remoteDataSource.SomeRemoteDataSource
import com.example.androidapplicationtemplate.domain.repository.SomeRepository
import com.example.androidapplicationtemplate.data.repositoryImpl.SomeRepositoryImpl
import com.example.androidapplicationtemplate.sample.data.PostRemoteDataSource
import com.example.androidapplicationtemplate.sample.domain.PostRepository
import com.example.androidapplicationtemplate.sample.data.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

	@Provides
	fun provideSomeRepository(
		someLocalDataSource: SomeLocalDataSource,
		someRemoteDataSource: SomeRemoteDataSource,
	): SomeRepository {
		return SomeRepositoryImpl(someLocalDataSource, someRemoteDataSource)
	}

	@Provides
	fun providePostRepository(
		someRemoteDataSource: PostRemoteDataSource,
	): PostRepository {
		return PostRepositoryImpl(someRemoteDataSource)
	}


}