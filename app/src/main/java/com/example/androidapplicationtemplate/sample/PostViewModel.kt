package com.example.androidapplicationtemplate.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapplicationtemplate.domain.usecase.SomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
	private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

	fun getPosts() {
		viewModelScope.launch {
			getPostsUseCase.getPosts()
		}
	}


}