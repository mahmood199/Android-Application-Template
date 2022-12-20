package com.example.androidapplicationtemplate.core.di

import com.example.androidapplicationtemplate.domain.repository.SomeRepository
import com.example.androidapplicationtemplate.domain.usecase.SomeUseCase
import com.example.androidapplicationtemplate.sample.domain.GetPostsUseCase
import com.example.androidapplicationtemplate.sample.domain.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

	@Provides
	fun provideSomeUseCase(
		someRepository: SomeRepository,
	): SomeUseCase = SomeUseCase(someRepository)

	@Provides
	fun provideGetPostUseCase(
		postRepository: PostRepository,
	): GetPostsUseCase = GetPostsUseCase(postRepository)

}