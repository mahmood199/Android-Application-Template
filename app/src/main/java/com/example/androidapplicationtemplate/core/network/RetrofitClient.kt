package com.example.androidapplicationtemplate.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

	private lateinit var retrofit: Retrofit
	const val BASE_URL = "https://jsonplaceholder.typicode.com/"

	fun getClient(): Retrofit {
		return if (this::retrofit.isInitialized)
			retrofit
		else {
			retrofit = Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(getOkhttpClient())
				.baseUrl(BASE_URL)
				.build()
			retrofit
		}
	}


	private fun getOkhttpClient(): OkHttpClient = OkHttpClient.Builder()
		.addNetworkInterceptor(getHTTPLoggingInterceptor())
		.build()


	private fun getHTTPLoggingInterceptor(): HttpLoggingInterceptor {
		val logging = HttpLoggingInterceptor()
		logging.level = HttpLoggingInterceptor.Level.BODY
		return logging
	}


}