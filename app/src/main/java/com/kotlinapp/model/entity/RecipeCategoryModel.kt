package com.kotlinapp.model.entity

import com.google.gson.annotations.SerializedName

data class RecipeCategoryModel(
    @SerializedName("categories")
    val categories: ArrayList<Category>
) {
    data class Category(
        @SerializedName("idCategory")
        val idCategory: String,
        @SerializedName("strCategory")
        val strCategory: String,
        @SerializedName("strCategoryDescription")
        val strCategoryDescription: String,
        @SerializedName("strCategoryThumb")
        val strCategoryThumb: String
    )
}