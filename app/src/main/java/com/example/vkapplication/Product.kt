package com.example.vkapplication

import android.view.textclassifier.ConversationActions.Message
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: Array<String>
)


data class ProductList(
    val products : List<Product>
)
