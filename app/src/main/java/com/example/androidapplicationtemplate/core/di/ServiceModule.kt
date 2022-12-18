package com.example.androidapplicationtemplate.core.di

import com.example.androidapplicationtemplate.core.network.RetrofitClient
import com.example.androidapplicationtemplate.data.remote.remoteServices.SomeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

	@Provides
	fun provideSomeService(): SomeService {
		return RetrofitClient.getClient().create(SomeService::class.java)
	}

}