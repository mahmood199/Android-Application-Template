package com.example.androidapplicationtemplate.data.remote.remoteServices

import com.example.androidapplicationtemplate.data.models.request.Request
import com.example.androidapplicationtemplate.data.models.response.Response

interface SomeService {
	suspend fun loginUser(request : Request) : Response
}