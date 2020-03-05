package com.kotlinapp.model.entity


import com.google.gson.annotations.SerializedName

data class RecipeListModel(
    @SerializedName("meals")
    val meals: ArrayList<Meal>
) {
    data class Meal(
        @SerializedName("idMeal")
        val idMeal: String,
        @SerializedName("strMeal")
        val strMeal: String,
        @SerializedName("strMealThumb")
        val strMealThumb: String
    )
}