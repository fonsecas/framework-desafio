package com.framework.desafio.android.data.repository

import com.framework.desafio.android.data.client.ApiClient
import com.framework.desafio.android.domain.boundary.FruitRepository
import com.framework.desafio.android.domain.entity.fruit.Fruit

class DefaultFruitRepository constructor(
    private val apiClient: ApiClient
) : FruitRepository {

    override suspend fun getFruitList(): List<Fruit>? {
        return apiClient.getFruitList()?.map { it.toDomainObject() }
    }
}