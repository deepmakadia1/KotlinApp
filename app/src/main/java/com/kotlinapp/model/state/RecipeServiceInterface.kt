package com.kotlinapp.model.state

import com.kotlinapp.model.entity.RecipeCategoryModel
import com.kotlinapp.model.entity.RecipeListModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeServiceInterface {

    @GET("categories.php")
    fun getCategories(): Observable<RecipeCategoryModel>

    @GET("filter.php")
    fun getRecipesList(
        @Query("c")
        categoryName: String
    ): Observable<RecipeListModel>

}