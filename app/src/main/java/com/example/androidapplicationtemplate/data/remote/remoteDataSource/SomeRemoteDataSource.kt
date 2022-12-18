package com.example.androidapplicationtemplate.data.remote.remoteDataSource

import com.example.androidapplicationtemplate.data.remote.remoteServices.SomeService
import javax.inject.Inject

class SomeRemoteDataSource @Inject constructor(
	val someService: SomeService,
) {

}