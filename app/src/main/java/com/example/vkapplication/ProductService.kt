package com.example.vkapplication


import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.stream.IntStream.range

class ProductService{
    private var products = mutableListOf<Product>()

    init {
        val ns = Networking.create("https://dummyjson.com/")
        val cl = ns.create(NetworkService::class.java)
        cl.doProductsGetRequestCall()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<ProductList>() {
                override fun onSuccess(@NonNull prod: ProductList) {
                    Log.i("json","onSuccess " + prod.products.size)
                    for (i in range(0, prod.products.size)){
                        products.add(
                            Product(prod.products[i].id,
                                prod.products[i].title,
                                prod.products[i].description,
                                prod.products[i].price,
                                prod.products[i].discountPercentage,
                                prod.products[i].rating,
                                prod.products[i].stock,
                                prod.products[i].brand,
                                prod.products[i].category,
                                prod.products[i].thumbnail,
                                prod.products[i].images)
                        )
                    }
                }

                override fun onError(@NonNull e: Throwable) {
                    Log.i("json","onError $e")
                }
            })



    }

    fun getProducts(): List<Product> = products
}