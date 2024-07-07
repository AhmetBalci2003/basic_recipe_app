package com.example.myrecipeapp


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel:ViewModel() {
     private  val _catergorisState= mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> =_catergorisState
    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response= recipeservice.getCategories()
                _catergorisState.value=_catergorisState.value.copy(list = response.categories,
                    loading=false,
                    error = null
                    )

            }
             catch (e:Exception){
                 _catergorisState.value=_catergorisState.value.copy(
                     loading = false,
                     error = "error fetching categories ${e.message}"

                 )

             }

        }


    }


    data class  RecipeState(val loading:Boolean=true,
                            val list:List<Category> = emptyList(),
                            val error:String?=null
                              )
}