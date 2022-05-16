package com.framework.desafio.android.presentation.di

import com.framework.desafio.android.domain.interector.GetFruitList
import org.koin.dsl.module

fun useCaseModule() = module {

    single {
        GetFruitList(get())
    }

}