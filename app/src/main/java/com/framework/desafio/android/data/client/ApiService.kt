package com.framework.desafio.android.data.client

import com.framework.desafio.android.data.entity.ApiFruit
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("fruit")
    suspend fun getFruitList(): Response<List<ApiFruit>>
}