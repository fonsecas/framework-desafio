package com.framework.desafio.android.domain.interector

import com.framework.desafio.android.domain.boundary.FruitRepository

class GetFruitList constructor(
    private val repository: FruitRepository
) {

    suspend fun execute() = repository.getFruitList()
}

