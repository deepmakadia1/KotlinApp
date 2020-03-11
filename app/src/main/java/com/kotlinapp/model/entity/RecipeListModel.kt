package com.kotlinapp.model.entity


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RecipeListModel(
    @SerializedName("meals")
    val meals: ArrayList<Meal>
) : Serializable {
    data class Meal(
        @SerializedName("idMeal")
        val idMeal: String,
        @SerializedName("strMeal")
        val strMeal: String,
        @SerializedName("strMealThumb")
        val strMealThumb: String
    ) : Serializable
}