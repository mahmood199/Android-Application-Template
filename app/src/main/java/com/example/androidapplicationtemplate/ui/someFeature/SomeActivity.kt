package com.example.androidapplicationtemplate.ui.someFeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.androidapplicationtemplate.R
import com.example.androidapplicationtemplate.databinding.ActivitySomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SomeActivity : AppCompatActivity() {

	private val someViewModel : SomeViewModel by viewModels()
	private val binding by lazy {
		ActivitySomeBinding.inflate(layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		setObservers()
	}

	private fun setObservers() {
		lifecycleScope.launch {
			someViewModel.state.collect {
				setUIState(it)
			}
		}

		lifecycleScope.launch {
			someViewModel.effect.collect {
				setUIEffect(it)
			}
		}
	}

	private fun setUIState(it: SomeState) {
		when(it) {
			SomeState.Idle -> {}
			SomeState.State1 -> TODO()
			SomeState.State2 -> TODO()
			SomeState.State3 -> TODO()
			SomeState.State4 -> TODO()
		}
	}

	private fun setUIEffect(it: SomeEffect) {
		when(it) {
			SomeEffect.Effect1 -> TODO()
			SomeEffect.Effect2 -> TODO()
			SomeEffect.Effect3 -> TODO()
			SomeEffect.Effect4 -> TODO()
		}
	}

}