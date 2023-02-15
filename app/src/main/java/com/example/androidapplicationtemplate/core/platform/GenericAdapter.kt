package com.example.androidapplicationtemplate.core.platform

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapplicationtemplate.R
import com.example.androidapplicationtemplate.data.models.entity.Entity1
import com.example.androidapplicationtemplate.data.models.entity.Entity2
import com.example.androidapplicationtemplate.data.models.entity.Entity3
import com.example.androidapplicationtemplate.data.models.entity.Entity4
import com.example.androidapplicationtemplate.databinding.ItemSomeLayout1Binding
import com.example.androidapplicationtemplate.databinding.ItemSomeLayout2Binding
import com.example.androidapplicationtemplate.databinding.ItemSomeLayout3Binding
import com.example.androidapplicationtemplate.databinding.NestedHorizontalRecyclerviewItemsBinding

class GenericAdapter(
    val clickAction: (RecyclerViewItemClickAction) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CROSS_FADE_ANIMATION_DURATION = 400
    }

    private val list = mutableListOf<AdapterItem>()
    /**
     * Source for saving nested recyclerview state
     * https://rubensousa.com/2019/08/27/saving_scroll_state_of_nested_recyclerviews/
     */
    private val scrollStates = hashMapOf<String, Parcelable?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_some_layout_1 -> ViewHolder1(
                ItemSomeLayout1Binding.inflate(
                    getLayoutInflater(parent.context), parent, false
                )
            )
            R.layout.item_some_layout_2 -> ViewHolder2(
                ItemSomeLayout2Binding.inflate(
                    getLayoutInflater(parent.context), parent, false
                )
            )
            R.layout.item_some_layout_3 -> ViewHolder3(
                ItemSomeLayout3Binding.inflate(
                    getLayoutInflater(parent.context), parent, false
                )
            )
            R.layout.nested_horizontal_recyclerview_items -> ViewHolder4(
                NestedHorizontalRecyclerviewItemsBinding.inflate(
                    getLayoutInflater(parent.context), parent, false
                )
            )
            else -> ViewHolder1(
                ItemSomeLayout1Binding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
        }
    }

    private fun getLayoutInflater(context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder1 -> holder.bindData(list[position] as Entity1, clickAction)
            is ViewHolder2 -> holder.bindData(list[position] as Entity2, clickAction)
            is ViewHolder3 -> holder.bindData(list[position] as Entity3, clickAction)
            is ViewHolder4 -> holder.bindData(list[position] as Entity4, clickAction)
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return if (list[position] is Entity1)
            R.layout.item_some_layout_1
        else if (list[position] is Entity2)
            R.layout.item_some_layout_2
        else if (list[position] is Entity3)
            R.layout.item_some_layout_3
        else if (list[position] is Entity4)
            R.layout.nested_horizontal_recyclerview_items
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
            with(binding) {
                tvSomeText1.text = entity1.someValue
                root.setOnClickListener {
                    clickAction(RecyclerViewItemClickAction.ClickInterceptorOne(1))
                }
            }
        }
    }

    inner class ViewHolder2(private val binding: ItemSomeLayout2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(entity2: Entity2, clickAction: (RecyclerViewItemClickAction) -> Unit) {
            with(binding) {
                tvSomeText2.text = entity2.someValue
                root.setOnClickListener {
                    clickAction(RecyclerViewItemClickAction.ClickInterceptorTwo(2))
                }
            }
        }
    }

    inner class ViewHolder3(private val binding: ItemSomeLayout3Binding) :
        RecyclerView.ViewHolder(binding.root) {

        val layoutManager by lazy {
            LinearLayoutManager(
                binding.root.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        lateinit var innerAdapter: GenericAdapter

        fun bindData(entity3: Entity3, clickAction: (RecyclerViewItemClickAction) -> Unit) {
            with(binding) {
                rvNested.layoutManager = layoutManager
                innerAdapter = GenericAdapter {
                    clickAction(RecyclerViewItemClickAction.ClickInterceptorThree)
                }
                rvNested.adapter = innerAdapter
                (rvNested.adapter as GenericAdapter).addItems(entity3.values)
                restoreScrollState(this@ViewHolder3)
            }
        }

        private fun restoreScrollState(holder: GenericAdapter.ViewHolder3) {
            val key = list[holder.adapterPosition].toString() + "${holder.adapterPosition}"
            val state = scrollStates[key]
            if (state != null) {
                holder.layoutManager.onRestoreInstanceState(state)
            } else {
                holder.layoutManager.scrollToPosition(0)
            }
        }
    }

    class ViewHolder4(private val binding: NestedHorizontalRecyclerviewItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(entity4: Entity4, clickAction: (RecyclerViewItemClickAction) -> Unit) {
            with(binding) {
                root.setOnClickListener {
                    clickAction(RecyclerViewItemClickAction.ClickInterceptorThree)
                }
                tvNestedItem.text = entity4.someValue
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        if (holder is ViewHolder3) {
            val key = list[holder.adapterPosition].toString() + "${holder.adapterPosition}"
            scrollStates[key] = holder.layoutManager.onSaveInstanceState()
        }
    }


}