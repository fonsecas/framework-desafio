package com.framework.desafio.android.presentation.di

import com.framework.desafio.android.data.repository.DefaultFruitRepository
import com.framework.desafio.android.domain.boundary.FruitRepository
import org.koin.dsl.module

fun repositoryModule() = module {

    single {
        DefaultFruitRepository(get()) as FruitRepository
    }
}