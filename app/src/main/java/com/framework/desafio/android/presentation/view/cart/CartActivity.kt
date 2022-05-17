package com.framework.desafio.android.presentation.view.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.framework.desafio.android.R
import com.framework.desafio.android.databinding.ActivityCartBinding
import com.framework.desafio.android.domain.entity.fruit.Fruit
import com.framework.desafio.android.presentation.util.base.BaseActivity
import com.framework.desafio.android.presentation.util.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class CartActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: CartViewModel by viewModel()

    private lateinit var binding: ActivityCartBinding

    private val intentFruit by lazy { intent.getSerializableExtra(FRUIT_LIST) as Array<Fruit> }
    private var fruitListt: Array<Fruit>? = null

    private lateinit var adapter: CartListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        fruitListt = intentFruit
        subscribeUi()
        setupAdapter()
        setupUi()
    }

    override fun subscribeUi() {
        _viewModel.placeholder.observe(this) { binding.placeholderView.setPlaceholder(it) }
    }

    private fun setupUi() {
        binding.backButton.setOnClickListener { this.onBackPressed() }

    }

    private fun setupAdapter() {
        adapter = CartListAdapter()
        binding.recyclerView.adapter = adapter
        adapter.submitList(fruitListt?.toMutableList())
    }

    companion object {
        private const val FRUIT_LIST = "FRUIT_LIST"

        fun createIntent(context: Context, fruitList: Array<Fruit>): Intent {
            return Intent(context, CartActivity::class.java).apply {
                putExtra(FRUIT_LIST, fruitList)
            }
        }
    }
}