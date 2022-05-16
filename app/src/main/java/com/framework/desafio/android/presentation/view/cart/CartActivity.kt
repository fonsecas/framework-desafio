package com.framework.desafio.android.presentation.view.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.framework.desafio.android.R
import com.framework.desafio.android.databinding.ActivityCartBinding
import com.framework.desafio.android.presentation.util.base.BaseActivity
import com.framework.desafio.android.presentation.util.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class CartActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: CartViewModel by viewModel()

    private lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        subscribeUi()
        setupUi()
    }

    override fun subscribeUi() {
        _viewModel.placeholder.observe(this) { binding.placeholderView.setPlaceholder(it) }
    }

    private fun setupUi() {
        binding.backButton.setOnClickListener { this.onBackPressed() }
    }
    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }
}