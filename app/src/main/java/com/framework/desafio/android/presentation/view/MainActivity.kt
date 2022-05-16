package com.framework.desafio.android.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.framework.desafio.android.R
import com.framework.desafio.android.databinding.ActivityMainBinding
import com.framework.desafio.android.domain.entity.fruit.Fruit
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private var mAuthListener: AuthStateListener? = null
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

    private fun subscribeUi() {
        _viewModel.users.observe(this, ::onUserReceived)
        _viewModel.placeholder.observe(this) { binding.placeholderView.setPlaceholder(it) }
    }

    private fun setupAdapter() {
        adapter = FruitListAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun onUserReceived(userList: List<Fruit?>?) {
        adapter.submitList(userList)
    }

//    private fun getFruitList() {
//        val myDB = FirebaseFirestore.getInstance()
//        myDB.collection("frutas")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    document.data
//                    Log.d(TAG, "${document.id} => ${document.data}")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.w(TAG, "Error getting documents.", exception)
//            }
//    }
}