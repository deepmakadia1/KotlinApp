package com.kotlinapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kotlinapp.model.entity.RecipeCategoryModel
import com.kotlinapp.repositories.RecipeRepository
import javax.inject.Inject

class RecipeCategoryListActivityViewModel @Inject internal constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    fun getCategories(): LiveData<ArrayList<RecipeCategoryModel.Category>>{
        return recipeRepository.getMutableLiveCategories()
    }

    fun getProgress():LiveData<Boolean>{
        return recipeRepository.getProgress()
    }


}
