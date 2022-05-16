package com.framework.desafio.android.presentation.di

import com.framework.desafio.android.presentation.view.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel {
        MainViewModel(get())
    }
}