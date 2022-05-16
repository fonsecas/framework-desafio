package com.framework.desafio.android.presentation.di

import com.framework.desafio.android.presentation.util.error.ErrorHandler
import org.koin.dsl.module

fun resourceModule() = module {

    single {
        ErrorHandler(get())
    }

}
