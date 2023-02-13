package com.example.androidapplicationtemplate.core.platform

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapplicationtemplate.R
import com.example.androidapplicationtemplate.data.models.entity.Entity1
import com.example.androidapplicationtemplate.data.models.entity.Entity2
import com.example.androidapplicationtemplate.databinding.ItemSomeLayout1Binding
import com.example.androidapplicationtemplate.databinding.ItemSomeLayout2Binding

class GenericAdapter(
    val clickAction: (RecyclerViewItemClickAction) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CROSS_FADE_ANIMATION_DURATION = 400
    }

    private val list = mutableListOf<AdapterItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_some_layout_1 -> ViewHolder1(
                ItemSomeLayout1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_some_layout_2 -> ViewHolder2(
                ItemSomeLayout2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ViewHolder1(
                ItemSomeLayout1Binding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder1 -> holder.bindData(list[position] as Entity1, clickAction)
            is ViewHolder2 -> holder.bindData(list[position] as Entity2, clickAction)
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return if (list[position] is Entity1)
            R.layout.item_some_layout_1
        else if (list[position] is Entity2)
            R.layout.item_some_layout_2
        else
            R.layout.item_some_layout_1
    }

    fun addItems(newItems: List<AdapterItem>) {
        val size = this.list.size
        this.list.addAll(newItems)
        notifyItemRangeChanged(size, newItems.size)
    }

    inner class ViewHolder1(private val binding: ItemSomeLayout1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(entity1: Entity1, clickAction: (RecyclerViewItemClickAction) -> Unit) {
            binding.apply {
                tvSomeText1.text = entity1.someValue
                root.setOnClickListener {
                    clickAction(RecyclerViewItemClickAction.ClickInterceptorOne(1))
                }
            }
        }

    }

    inner class ViewHolder2(private val binding: ItemSomeLayout2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(entity1: Entity2, clickAction: (RecyclerViewItemClickAction) -> Unit) {
            binding.apply {
                tvSomeText2.text = entity1.someValue
                root.setOnClickListener {
                    clickAction(RecyclerViewItemClickAction.ClickInterceptorTwo(2))
                }
            }
        }

    }


}