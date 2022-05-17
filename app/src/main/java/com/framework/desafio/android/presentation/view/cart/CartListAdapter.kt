package com.framework.desafio.android.presentation.view.cart

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.framework.desafio.android.domain.entity.fruit.Fruit

class CartListAdapter : ListAdapter<Fruit, CartListIViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListIViewHolder {
        return CartListIViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: CartListIViewHolder, position: Int) {
        holder.bind(
            currentList[position]
        )
    }

    override fun getItemCount(): Int = currentList.size

    companion object DiffUtilCallback : DiffUtil.ItemCallback<Fruit>() {
        override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit) = oldItem == newItem
    }
}