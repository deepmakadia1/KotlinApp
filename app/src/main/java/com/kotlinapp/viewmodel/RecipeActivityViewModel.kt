package com.kotlinapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kotlinapp.model.entity.RecipeModel
import com.kotlinapp.repositories.RecipeRepository
import javax.inject.Inject

class RecipeActivityViewModel @Inject internal constructor(private val recipeRepository: RecipeRepository): ViewModel(){

    fun getMeal(mealId:String?):LiveData<ArrayList<RecipeModel.Meal>>{
        return recipeRepository.getMutableLiveDataRecipe(mealId)
    }

    fun getProgress():LiveData<Boolean>{
        return recipeRepository.getProgress()
    }

}