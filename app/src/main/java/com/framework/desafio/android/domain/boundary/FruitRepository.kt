package com.framework.desafio.android.domain.boundary

import com.framework.desafio.android.domain.entity.fruit.Fruit

interface FruitRepository {
    suspend fun getFruitList(): List<Fruit?>?
}