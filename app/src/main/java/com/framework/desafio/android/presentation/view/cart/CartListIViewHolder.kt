package com.framework.desafio.android.presentation.view.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.framework.desafio.android.databinding.ListItemUserBinding
import com.framework.desafio.android.domain.entity.fruit.Fruit

class CartListIViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        fruit: Fruit
    ) {
        binding.name.text = fruit.name
        binding.price.text = fruit.price
        Glide
            .with(binding.root.context)
            .load(fruit.img.toUri())
            .circleCrop()
            .into(binding.picture)
    }

    companion object {
        fun inflate(parent: ViewGroup) = CartListIViewHolder(
            ListItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}