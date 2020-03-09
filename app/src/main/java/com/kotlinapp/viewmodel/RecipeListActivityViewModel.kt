package com.kotlinapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.repositories.RecipeRepository
import javax.inject.Inject

class RecipeListActivityViewModel @Inject internal constructor(private val recipeRepository: RecipeRepository): ViewModel() {

    fun getRecipeList(categoryName:String?):LiveData<ArrayList<RecipeListModel.Meal>>{
        return recipeRepository.getRecipeList(categoryName)
    }

    fun getProgress():LiveData<Boolean>{
        return recipeRepository.getProgress()
    }

}