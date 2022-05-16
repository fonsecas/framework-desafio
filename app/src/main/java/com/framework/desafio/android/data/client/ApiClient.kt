package com.framework.desafio.android.data.client

import com.framework.desafio.android.data.entity.ApiFruit
import com.framework.desafio.android.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getFruitList(): List<ApiFruit>? {
        return makeRequest(apiService.getFruitList())
    }
}