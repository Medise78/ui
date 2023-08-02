package com.medise.nahalit.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medise.nahalit.common.Resources
import com.medise.nahalit.domain.model.product.ProductItem
import com.medise.nahalit.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsScreenViewModel(
    private val repository: ProductsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ProductState())
    val state: State<ProductState> get() = _state

    init {
        savedStateHandle.get<Int>("id")?.let {
            fetchProductDetailsById(it)
        }
    }

    private fun fetchProductDetailsById(id: Int) {
        viewModelScope.launch {
            repository.getProductById(id).onEach { resources ->
                when (resources) {
                    is Resources.Success -> {
                        _state.value = state.value.copy(
                            success = resources.data,
                            loading = false
                        )
                    }
                    is Resources.Loading -> {
                        _state.value = state.value.copy(
                            loading = true
                        )
                    }
                    is Resources.Error -> {
                        _state.value = state.value.copy(
                            error = resources.message ?: "Error",
                            loading = false
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}

data class ProductState(
    val success: ProductItem? = null,
    val loading: Boolean = false,
    val error: String = ""
)