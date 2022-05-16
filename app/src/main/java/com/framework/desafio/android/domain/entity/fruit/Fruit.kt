package com.framework.desafio.android.domain.entity.fruit

import java.io.Serializable

data class Fruit(
    val id: Int,
    val img: String,
    val name: String,
    val price: String,
) : Serializable