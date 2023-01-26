package com.example.androidapplicationtemplate.core.di

import com.example.androidapplicationtemplate.data.local.dao.SomeDao
import com.example.androidapplicationtemplate.data.local.localDataSource.SomeLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

	@Provides
	fun provideLocalDataSource(someDao: SomeDao): SomeLocalDataSource {
		return SomeLocalDataSource(someDao)
	}

}