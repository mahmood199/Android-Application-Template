package com.example.androidapplicationtemplate.ui.someFeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.androidapplicationtemplate.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SomeActivity : AppCompatActivity() {

	private val someViewModel : SomeViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_some)
	}
}