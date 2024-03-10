package com.example.vkapplication

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {

    @GET("products")
    fun doProductsGetRequestCall(): Single<ProductList>
}