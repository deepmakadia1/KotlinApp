package com.kotlinapp.repositories

import androidx.lifecycle.MutableLiveData
import com.kotlinapp.model.entity.RecipeCategoryModel
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.model.entity.RecipeModel
import com.kotlinapp.model.state.RecipeServiceInterface
import com.kotlinapp.network.RXRetroManager
import javax.inject.Inject

class RecipeRepository @Inject constructor(private var recipeServiceInterface: RecipeServiceInterface?) {

    private var mutableLiveDataCategory = MutableLiveData<ArrayList<RecipeCategoryModel.Category>>()
    private var categories = ArrayList<RecipeCategoryModel.Category>()
    private var mutableProgress = MutableLiveData<Boolean>()

    fun getMutableLiveCategories(): MutableLiveData<ArrayList<RecipeCategoryModel.Category>> {

        showProgress()

        recipeServiceInterface?.getCategories()?.let {
            object : RXRetroManager<RecipeCategoryModel>() {
                override fun onSuccess(Response: RecipeCategoryModel) {
                    hideProgress()
                    categories.clear()
                    categories.addAll(Response.categories)
                    mutableLiveDataCategory.value = categories

                }

                override fun onFailure(msg: String) {
                    hideProgress()
                }
            }.rxSingleCall(it)
        }

        return mutableLiveDataCategory
    }

    private var mutableLiveDataRecipeList = MutableLiveData<ArrayList<RecipeListModel.Meal>>()
    private var recipeList = ArrayList<RecipeListModel.Meal>()

    fun getRecipeList(categoryName: String): MutableLiveData<ArrayList<RecipeListModel.Meal>> {
        showProgress()

        recipeServiceInterface?.getRecipesList(categoryName)?.let {
            object : RXRetroManager<RecipeListModel>() {
                override fun onSuccess(Response: RecipeListModel) {
                    hideProgress()
                    recipeList.clear()
                    recipeList.addAll(Response.meals)
                    mutableLiveDataRecipeList.value = recipeList
                }

                override fun onFailure(msg: String) {
                    hideProgress()
                }

            }.rxSingleCall(it)
        }

        return mutableLiveDataRecipeList
    }

    private var mutableLiveDataRecipe = MutableLiveData<ArrayList<RecipeModel.Meal>>()
    private var recipe = ArrayList<RecipeModel.Meal>()

    fun getMutableLiveDataRecipe(mealId: String): MutableLiveData<ArrayList<RecipeModel.Meal>> {

        showProgress()

        recipeServiceInterface?.getRecipe(mealId)?.let {
            object : RXRetroManager<RecipeModel>() {
                override fun onSuccess(Response: RecipeModel) {
                    hideProgress()
                    recipe.clear()
                    recipe.addAll(Response.meals)
                    mutableLiveDataRecipe.value = recipe
                }

                override fun onFailure(msg: String) {
                    hideProgress()
                }

            }.rxSingleCall(it)
        }



        return mutableLiveDataRecipe
    }

    fun getProgress(): MutableLiveData<Boolean> {
        return mutableProgress
    }

    private fun hideProgress() {
        mutableProgress.postValue(false)
    }

    private fun showProgress() {
        mutableProgress.value = true
    }

}