package com.example.androidapplicationtemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TemplateApplication : Application() {

	override fun onCreate() {
		super.onCreate()
	}

}