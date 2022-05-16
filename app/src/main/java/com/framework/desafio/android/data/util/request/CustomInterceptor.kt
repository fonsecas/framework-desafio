package com.framework.desafio.android.data.util.request

import android.content.Context
import com.framework.desafio.android.data.util.network.cacheSize
import com.framework.desafio.android.data.util.network.hasNetwork
import okhttp3.Cache
import okhttp3.OkHttpClient

fun CustomInterceptor(context: Context) : OkHttpClient {

    val cacheApp = Cache(context.cacheDir, cacheSize)

    return OkHttpClient.Builder()
        .cache(cacheApp)
        .addInterceptor { chain ->

            var request = chain.request()

            request = if (hasNetwork(context)!!)
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header(
                    "Cache-Control",
                    "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                ).build()
            chain.proceed(request)
        }
        .build()
}