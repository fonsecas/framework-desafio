package com.framework.desafio.android.data.entity

import com.google.gson.annotations.SerializedName
import com.framework.desafio.android.domain.entity.fruit.Fruit

data class ApiFruit(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
) {

    fun toDomainObject() = Fruit(
        id = id,
        img = img,
        name = name,
        price = username
    )
}