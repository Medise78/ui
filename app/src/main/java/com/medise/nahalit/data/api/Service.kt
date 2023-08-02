package com.medise.nahalit.data.api

import com.medise.nahalit.common.Resources
import com.medise.nahalit.domain.model.product.Product
import com.medise.nahalit.domain.model.product.ProductItem
import com.medise.nahalit.domain.model.search.SearchProduct
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("product")
    suspend fun getAllProducts(): Resources<Product>

    @GET("product/{id}/")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Resources<ProductItem>

    @GET("search")
    suspend fun searchProduct(
        @Query("search") query: String
    ): Resources<SearchProduct>
}