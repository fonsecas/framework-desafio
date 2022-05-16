package com.framework.desafio.android.presentation.util.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.framework.desafio.android.presentation.util.navigation.NavData

abstract class BaseActivity : AppCompatActivity() {

    abstract val baseViewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeUi()
    }

    open fun subscribeUi() {
        baseViewModel.goTo.observe(this, ::onGoTo)
    }

    private fun onGoTo(navData: NavData?) {
        navData?.navigate(this)
    }
}
