package com.framework.desafio.android.presentation

import android.app.Application
import com.framework.desafio.android.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DesafioAndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DesafioAndroidApplication)
            modules(
                listOf(
                    networkingModule(),
                    viewModelModule(),
                    repositoryModule(),
                    useCaseModule(),
                    resourceModule(),
                )
            )
        }
    }
}