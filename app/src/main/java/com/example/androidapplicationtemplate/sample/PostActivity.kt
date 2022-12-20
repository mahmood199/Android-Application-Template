package com.example.androidapplicationtemplate.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.androidapplicationtemplate.R
import com.example.androidapplicationtemplate.ui.someFeature.SomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity() {

	private lateinit var viewModel : PostViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_post)
		viewModel = ViewModelProvider(this)[PostViewModel::class.java]
		val x = viewModel.getPosts()
		Toast.makeText(this, "$x", Toast.LENGTH_SHORT).show()
	}

}