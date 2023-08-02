package com.medise.nahalit.data.repository

import com.medise.nahalit.common.Resources
import com.medise.nahalit.data.api.Service
import com.medise.nahalit.domain.model.product.Product
import com.medise.nahalit.domain.model.product.ProductItem
import com.medise.nahalit.domain.model.search.SearchProduct
import com.medise.nahalit.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsRepositoryImpl(
    private val service: Service
) : ProductsRepository {

    override suspend fun getAllProducts(): Flow<Resources<Product>> = flow {
        emit(service.getAllProducts())
    }

    override suspend fun getProductById(id: Int): Flow<Resources<ProductItem>> = flow {
        emit(service.getProductById(id))
    }

    override suspend fun searchProduct(query: String): Flow<Resources<SearchProduct>> = flow {
        emit(service.searchProduct(query))
    }
}