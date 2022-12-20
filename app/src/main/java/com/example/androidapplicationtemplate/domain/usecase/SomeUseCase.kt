package com.example.androidapplicationtemplate.domain.usecase

import com.example.androidapplicationtemplate.domain.repository.SomeRepository
import javax.inject.Inject

class SomeUseCase @Inject constructor(
	someRepository: SomeRepository,
) {
}