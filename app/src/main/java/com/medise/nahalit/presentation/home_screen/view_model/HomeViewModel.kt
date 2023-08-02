package com.medise.nahalit.presentation.home_screen.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medise.nahalit.common.Resources
import com.medise.nahalit.domain.model.product.Product
import com.medise.nahalit.domain.model.search.SearchProduct
import com.medise.nahalit.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProductsState())
    val state: State<ProductsState> get() = _state

    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> get() = _searchState

    init {
        fetchProducts()
    }

    fun searchProduct(query: String) {
        viewModelScope.launch {
            repository.searchProduct(query).onEach { resource ->
                when (resource) {
                    is Resources.Success -> {
                        _searchState.value = searchState.value.copy(
                            products = resource.data,
                            loading = false
                        )
                    }
                    is Resources.Error -> {
                        _searchState.value = searchState.value.copy(
                            error = resource.message?:"",
                            loading = false
                        )
                    }
                    is Resources.Loading -> {
                        _searchState.value = searchState.value.copy(
                            loading = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            repository.getAllProducts().onEach { resource ->
                when (resource) {
                    is Resources.Success -> {
                        _state.value = state.value.copy(
                            products = resource.data,
                            loading = false
                        )
                    }
                    is Resources.Error -> {
                        _state.value = state.value.copy(
                            error = resource.message ?: "Error",
                            loading = false
                        )
                    }
                    is Resources.Loading -> {
                        _state.value = state.value.copy(
                            loading = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}

data class ProductsState(
    val products: Product? = null,
    val loading: Boolean = false,
    val error: String = ""
)

data class SearchState(
    val products: SearchProduct? = null,
    val loading: Boolean = false,
    val error: String = ""
)