package com.medise.nahalit.domain.repository

import com.medise.nahalit.common.Resources
import com.medise.nahalit.domain.model.product.Product
import com.medise.nahalit.domain.model.product.ProductItem
import com.medise.nahalit.domain.model.search.SearchProduct
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getAllProducts(): Flow<Resources<Product>>
    suspend fun getProductById(id: Int): Flow<Resources<ProductItem>>
    suspend fun searchProduct(query: String): Flow<Resources<SearchProduct>>
}