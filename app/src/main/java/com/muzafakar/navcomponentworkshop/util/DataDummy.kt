package com.muzafakar.navcomponentworkshop.util

import com.muzafakar.navcomponentworkshop.model.Product

object DataDummy {
    fun generateProduct(): List<Product> {
        val productList = mutableListOf<Product>()
        for (i in 1..100) {
            productList.add(Product(i, "Product-$i", i * 1000, "https://i.picsum.photos/id/${i}/300/200.jpg"))
        }
        return productList
    }
}