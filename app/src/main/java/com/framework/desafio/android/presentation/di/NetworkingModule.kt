package com.framework.desafio.android.presentation.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.framework.desafio.android.BuildConfig
import com.framework.desafio.android.data.client.ApiClient
import com.framework.desafio.android.data.client.ApiService
import com.framework.desafio.android.data.util.request.CustomInterceptor
import com.framework.desafio.android.data.util.resource.API_DATE_FORMAT
import com.framework.desafio.android.data.util.resource.API_ENDPOINT_NAMED
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun networkingModule() = module {
    single {
        CustomInterceptor(androidContext())
    }

    single {
        GsonConverterFactory.create()
    }

    single(named(API_ENDPOINT_NAMED)) {
        BuildConfig.API_ENDPOINT
    }

    single {
        GsonBuilder()
            .serializeNulls()
            .setDateFormat(API_DATE_FORMAT)
            .create()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(get<String>(named(API_ENDPOINT_NAMED)))
            .addConverterFactory(GsonConverterFactory.create(get<Gson>()))
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    single {
        ApiClient(get())
    }
}