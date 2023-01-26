package com.example.androidapplicationtemplate.core.di

import com.example.androidapplicationtemplate.core.local.SomeDatabase
import com.example.androidapplicationtemplate.data.local.dao.SomeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

	@Provides
	fun providesSomeDao(someDatabase: SomeDatabase): SomeDao {
		return someDatabase.someDao()
	}

}