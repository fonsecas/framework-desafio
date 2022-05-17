package com.framework.desafio.android.presentation.view.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.framework.desafio.android.R
import com.framework.desafio.android.databinding.ActivityMainBinding
import com.framework.desafio.android.domain.entity.fruit.Fruit
import com.framework.desafio.android.presentation.util.base.BaseActivity
import com.framework.desafio.android.presentation.util.base.BaseViewModel
import com.framework.desafio.android.presentation.view.cart.CartActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private var mAuthListener: AuthStateListener? = null
    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: FruitListAdapter

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        mAuthListener = AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                Log.d("AUTH", "onAuthStateChanged:signed_in:" + user.uid)
            } else {
                Log.d("AUTH", "onAuthStateChanged:signed_out")
            }
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        subscribeUi()
        setupAdapter()

        mAuth!!.signInWithEmailAndPassword("gabriel@mail.com", "gabriel")
            .addOnCompleteListener(
                this
            ) { task ->
                if (!task.isSuccessful) {
                    Log.w("AUTH", "Falha ao efetuar o Login: ", task.exception)
                } else {
                    Log.d("AUTH", "Login Efetuado com sucesso!!!")
                }
            }
        setupUi()
    }

    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener(mAuthListener!!)
    }

    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) {
            mAuth!!.removeAuthStateListener(mAuthListener!!)
        }
    }


    private fun setupUi() {
        binding.cartButton.setOnClickListener { onCartButtonClicked() }
    }

    private fun onCartButtonClicked() {
        val intent = Intent(this, CartActivity::class.java)
        intent.putExtra("FRUIT_LIST", _viewModel.cartList.toTypedArray() )
        startActivity(intent)
    }

    override fun subscribeUi() {
        _viewModel.users.observe(this, ::onFruitListReceived)
        _viewModel.placeholder.observe(this) { binding.placeholderView.setPlaceholder(it) }
    }

    private fun setupAdapter() {
        adapter = FruitListAdapter(
            _viewModel::onAddCartClicked
        )
        binding.recyclerView.adapter = adapter
    }

    private fun onFruitListReceived(userList: List<Fruit?>?) {
        adapter.submitList(userList)
    }
}