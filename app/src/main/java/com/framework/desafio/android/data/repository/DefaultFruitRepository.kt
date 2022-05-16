package com.framework.desafio.android.data.repository

import com.framework.desafio.android.data.client.ApiClient
import com.framework.desafio.android.domain.boundary.FruitRepository
import com.framework.desafio.android.domain.entity.fruit.Fruit

class DefaultFruitRepository constructor(
    private val apiClient: ApiClient
) : FruitRepository {

    override suspend fun getFruitList(): List<Fruit> {
        return listOf(
            Fruit(0,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg",
                "5,99",
                "Maça"
            ),
            Fruit(1,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Bananas_white_background_DS.jpg/320px-Bananas_white_background_DS.jpg",
                "12,00",
                "Banana"
            ),
            Fruit(2,
                "http://d3ugyf2ht6aenh.cloudfront.net/stores/001/194/977/products/abacaxi-perola11-d39b14434678c43cc815897563419666-640-0.jpg",
                "9",
                "Abacaxi"
            ),
            Fruit(3,
                "https://st.depositphotos.com/1902163/1634/i/600/depositphotos_16347875-stock-photo-pearpear-pear-fruit-pear-isolated.jpg",
                "9,49",
                "Pera"
            ),
            Fruit(4,
                "https://www.teclasap.com.br/wp-content/uploads/2007/03/manga.png",
                "4,45",
                "Manga"
            )
        )
    }
}