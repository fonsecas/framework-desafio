package com.framework.desafio.android.domain.interector

import com.framework.desafio.android.domain.boundary.FruitRepository
import com.framework.desafio.android.domain.entity.fruit.Fruit

interface IGetFruitList {
    suspend fun getFruitList(): List<Fruit?>?
}

class GetFruitList(private val repository: FruitRepository) : IGetFruitList {
    override suspend fun getFruitList(): List<Fruit?>? {
        return repository.getFruitList()
    }
}


