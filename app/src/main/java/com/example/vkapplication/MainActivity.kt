package com.example.vkapplication

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val productService: ProductService
        get() = (applicationContext as App).productService
    lateinit var products: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvProducts = findViewById<RecyclerView>(R.id.products_RecyclerView)
        products = productService.getProducts()
        val adapter = ProductAdapter(products)
        rvProducts.adapter = adapter
        rvProducts.layoutManager = LinearLayoutManager(this)
    }
}