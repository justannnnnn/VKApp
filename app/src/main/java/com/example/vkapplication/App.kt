package com.example.vkapplication

import android.app.Application

class App : Application() {
    val productService = ProductService()
}