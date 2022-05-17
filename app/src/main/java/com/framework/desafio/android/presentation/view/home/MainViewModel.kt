package com.framework.desafio.android.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.framework.desafio.android.domain.entity.fruit.Fruit
import com.framework.desafio.android.domain.interector.GetFruitList
import com.framework.desafio.android.presentation.util.base.BaseViewModel

class MainViewModel constructor(
    private val getFruitList: GetFruitList,
) : BaseViewModel() {

    val users: LiveData<List<Fruit?>?> get() = _users

    private val _users by lazy { MutableLiveData<List<Fruit?>?>() }

   var cartList: MutableList<Fruit> = mutableListOf()


    init {
        getFruitList()
    }

    fun getFruitList() {
        launchDataLoad {
            _users.value = getFruitList.execute()
        }
    }

    fun onAddCartClicked(fruit: Fruit){
        cartList.size
        cartList.add(fruit)
        cartList
    }
}