package com.muzafakar.navcomponentworkshop.model

import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val imgUrl: String
) : Serializable