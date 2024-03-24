package com.example.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    data class RecipeState(
        val loading:Boolean=true,
        val list: List<catagory> = emptyList(),
        val error: String?=null
    )

    private var _categorieState= mutableStateOf(RecipeState())
    val catagoryState:State<RecipeState> = _categorieState

    init {
        fetchCategory()
    }

    private fun fetchCategory(){
        viewModelScope.launch {
            try {
                val responds= recipeService.getCategories()
                _categorieState.value= _categorieState.value.copy(
                    loading = false,
                    list = responds.categories,
                    error = null
                )
            }catch (e: Exception){
                _categorieState.value=_categorieState.value.copy(
                    loading = false,
                    error = "Error fetching category ${e.message}"
                )
            }
        }
    }

}