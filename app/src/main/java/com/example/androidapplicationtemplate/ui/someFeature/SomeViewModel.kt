package com.example.androidapplicationtemplate.ui.someFeature

import androidx.lifecycle.ViewModel
import com.example.androidapplicationtemplate.domain.usecase.SomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SomeViewModel @Inject constructor(
	someUseCase: SomeUseCase
) : ViewModel() {



}