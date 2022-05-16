package com.framework.desafio.android.presentation.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.framework.desafio.android.databinding.ListItemUserBinding
import com.framework.desafio.android.domain.entity.fruit.Fruit

class FruitListIViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: Fruit) {
        binding.name.text = user.name
        binding.username.text = user.username
        Glide
            .with(binding.root.context)
            .load(user.img.toUri())
            .circleCrop()
            .into(binding.picture)
    }

    companion object {
        fun inflate(parent: ViewGroup) = FruitListIViewHolder(
            ListItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}