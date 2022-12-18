package com.example.androidapplicationtemplate.domain.usecase

import com.example.androidapplicationtemplate.data.repository.SomeRepository
import javax.inject.Inject

class SomeUseCase @Inject constructor(
	someRepository: SomeRepository,
) {
}