package com.framework.desafio.android.presentation.view.cart

import android.content.Context
import com.framework.desafio.android.presentation.util.navigation.NavData

class CartNavData : NavData {

    override fun navigate(context: Context) {
        context.startActivity(CartActivity.createIntent(context))
    }
}