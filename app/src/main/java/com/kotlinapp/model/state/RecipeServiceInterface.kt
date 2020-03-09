package com.kotlinapp.model.state

import com.kotlinapp.model.entity.RecipeCategoryModel
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.model.entity.RecipeModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeServiceInterface {

    @GET("categories.php")
    fun getCategories(): Observable<RecipeCategoryModel>

    @GET("filter.php")
    fun getRecipesList(
        @Query("c") categoryName: String?
    ): Observable<RecipeListModel>

    @GET("lookup.php")
    fun getRecipe(
        @Query("i") mealId:String?
    ):Observable<RecipeModel>

}