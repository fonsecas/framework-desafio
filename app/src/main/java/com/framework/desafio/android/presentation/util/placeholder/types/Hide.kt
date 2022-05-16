package com.framework.desafio.android.presentation.util.placeholder.types

import com.framework.desafio.android.presentation.util.placeholder.Placeholder

class Hide : Placeholder {
    override val progressVisible: Boolean get() = false
    override val visible: Boolean get() = false
}