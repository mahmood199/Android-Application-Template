package com.example.androidapplicationtemplate.ui.someFeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.androidapplicationtemplate.R
import com.example.androidapplicationtemplate.core.platform.AdapterItem
import com.example.androidapplicationtemplate.core.platform.GenericAdapter
import com.example.androidapplicationtemplate.core.platform.RecyclerViewItemClickAction
import com.example.androidapplicationtemplate.data.models.entity.Entity1
import com.example.androidapplicationtemplate.data.models.entity.Entity2
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
	private val adapter = GenericAdapter {
		handleClickListener(it)
	}

	private fun handleClickListener(it: RecyclerViewItemClickAction) {
		when(it) {
			is RecyclerViewItemClickAction.ClickInterceptorOne -> {
				Toast.makeText(this, "${it.viewType} clicked", Toast.LENGTH_SHORT).show()
			}
			is RecyclerViewItemClickAction.ClickInterceptorTwo -> {
				Toast.makeText(this, "${it.viewType} clicked", Toast.LENGTH_SHORT).show()
			}
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		setObservers()
		addItemsToList()
	}

	private fun addItemsToList() {
		val list = mutableListOf<AdapterItem>()
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		list.add(Entity1("View 1"))
		list.add(Entity2("View 2"))
		adapter.addItems(list)
		binding.apply {
			rvSome.adapter = adapter
		}
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