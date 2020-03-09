package com.kotlinapp.model.entity


import com.google.gson.annotations.SerializedName

data class RecipeModel(
    @SerializedName("meals")
    val meals: ArrayList<Meal>
) {
    data class Meal(
        @SerializedName("dateModified")
        val dateModified: Any,
        @SerializedName("idMeal")
        val idMeal: String,
        @SerializedName("strArea")
        val strArea: String,
        @SerializedName("strCategory")
        val strCategory: String,
        @SerializedName("strDrinkAlternate")
        val strDrinkAlternate: Any,
        @SerializedName("strIngredient1")
        val strIngredient1: String,
        @SerializedName("strIngredient10")
        val strIngredient10: String,
        @SerializedName("strIngredient11")
        val strIngredient11: String,
        @SerializedName("strIngredient12")
        val strIngredient12: String,
        @SerializedName("strIngredient13")
        val strIngredient13: String,
        @SerializedName("strIngredient14")
        val strIngredient14: String,
        @SerializedName("strIngredient15")
        val strIngredient15: String,
        @SerializedName("strIngredient16")
        val strIngredient16: String,
        @SerializedName("strIngredient17")
        val strIngredient17: String,
        @SerializedName("strIngredient18")
        val strIngredient18: String,
        @SerializedName("strIngredient19")
        val strIngredient19: String,
        @SerializedName("strIngredient2")
        val strIngredient2: String,
        @SerializedName("strIngredient20")
        val strIngredient20: String,
        @SerializedName("strIngredient3")
        val strIngredient3: String,
        @SerializedName("strIngredient4")
        val strIngredient4: String,
        @SerializedName("strIngredient5")
        val strIngredient5: String,
        @SerializedName("strIngredient6")
        val strIngredient6: String,
        @SerializedName("strIngredient7")
        val strIngredient7: String,
        @SerializedName("strIngredient8")
        val strIngredient8: String,
        @SerializedName("strIngredient9")
        val strIngredient9: String,
        @SerializedName("strInstructions")
        val strInstructions: String,
        @SerializedName("strMeal")
        val strMeal: String,
        @SerializedName("strMealThumb")
        val strMealThumb: String,
        @SerializedName("strMeasure1")
        val strMeasure1: String,
        @SerializedName("strMeasure10")
        val strMeasure10: String,
        @SerializedName("strMeasure11")
        val strMeasure11: String,
        @SerializedName("strMeasure12")
        val strMeasure12: String,
        @SerializedName("strMeasure13")
        val strMeasure13: String,
        @SerializedName("strMeasure14")
        val strMeasure14: String,
        @SerializedName("strMeasure15")
        val strMeasure15: String,
        @SerializedName("strMeasure16")
        val strMeasure16: String,
        @SerializedName("strMeasure17")
        val strMeasure17: String,
        @SerializedName("strMeasure18")
        val strMeasure18: String,
        @SerializedName("strMeasure19")
        val strMeasure19: String,
        @SerializedName("strMeasure2")
        val strMeasure2: String,
        @SerializedName("strMeasure20")
        val strMeasure20: String,
        @SerializedName("strMeasure3")
        val strMeasure3: String,
        @SerializedName("strMeasure4")
        val strMeasure4: String,
        @SerializedName("strMeasure5")
        val strMeasure5: String,
        @SerializedName("strMeasure6")
        val strMeasure6: String,
        @SerializedName("strMeasure7")
        val strMeasure7: String,
        @SerializedName("strMeasure8")
        val strMeasure8: String,
        @SerializedName("strMeasure9")
        val strMeasure9: String,
        @SerializedName("strSource")
        val strSource: Any,
        @SerializedName("strTags")
        val strTags: String,
        @SerializedName("strYoutube")
        val strYoutube: String

    ) {
        fun getIngredients(): ArrayList<String?> {
            val ingredients = ArrayList<String?>()
            ingredients.clear()
            if (strMeasure1 != null && strIngredient1.isNotEmpty()) {
                if (strMeasure1 != null && strMeasure1.isNotEmpty())
                    ingredients.add("$strIngredient1 ($strMeasure1)")
                else
                    ingredients.add(strIngredient1)
            }
            if (strMeasure2 != null && strIngredient2.isNotEmpty()) {
                if (strMeasure2 != null && strMeasure2.isNotEmpty())
                    ingredients.add("$strIngredient2 ($strMeasure2)")
                else
                    ingredients.add(strIngredient2)
            }
            if (strMeasure3 != null && strIngredient3.isNotEmpty()) {
                if (strMeasure3 != null && strMeasure3.isNotEmpty())
                    ingredients.add("$strIngredient3 ($strMeasure3)")
                else
                    ingredients.add(strIngredient3)
            }
            if (strMeasure4 != null && strIngredient4.isNotEmpty()) {
                if (strMeasure4 != null && strMeasure4.isNotEmpty())
                    ingredients.add("$strIngredient4 ($strMeasure4)")
                else
                    ingredients.add(strIngredient4)
            }
            if (strMeasure5 != null && strIngredient5.isNotEmpty()) {
                if (strMeasure5 != null && strMeasure5.isNotEmpty())
                    ingredients.add("$strIngredient5 ($strMeasure5)")
                else
                    ingredients.add(strIngredient5)
            }
            if (strMeasure6 != null && strIngredient6.isNotEmpty()) {
                if (strMeasure6 != null && strMeasure6.isNotEmpty())
                    ingredients.add("$strIngredient6 ($strMeasure6)")
                else
                    ingredients.add(strIngredient6)
            }
            if (strMeasure7 != null && strIngredient7.isNotEmpty()) {
                if (strMeasure7 != null && strMeasure7.isNotEmpty())
                    ingredients.add("$strIngredient7 ($strMeasure7)")
                else
                    ingredients.add(strIngredient7)
            }
            if (strMeasure8 != null && strIngredient8.isNotEmpty()) {
                if (strMeasure8 != null && strMeasure8.isNotEmpty())
                    ingredients.add("$strIngredient8 ($strMeasure8)")
                else
                    ingredients.add(strIngredient8)
            }
            if (strMeasure9 != null && strIngredient9.isNotEmpty()) {
                if (strMeasure9 != null && strMeasure9.isNotEmpty())
                    ingredients.add("$strIngredient9 ($strMeasure9)")
                else
                    ingredients.add(strIngredient9)
            }
            if (strMeasure10 != null && strIngredient10.isNotEmpty()) {
                if (strMeasure10 != null && strMeasure10.isNotEmpty())
                    ingredients.add("$strIngredient10 ($strMeasure10)")
                else
                    ingredients.add(strIngredient10)
            }
            if (strMeasure11 != null && strIngredient11.isNotEmpty()) {
                if (strMeasure11 != null && strMeasure11.isNotEmpty())
                    ingredients.add("$strIngredient11 ($strMeasure11)")
                else
                    ingredients.add(strIngredient11)
            }
            if (strMeasure12 != null && strIngredient12.isNotEmpty()) {
                if (strMeasure12 != null && strMeasure12.isNotEmpty())
                    ingredients.add("$strIngredient12 ($strMeasure12)")
                else
                    ingredients.add(strIngredient12)
            }
            if (strMeasure13 != null && strIngredient13.isNotEmpty()) {
                if (strMeasure13 != null && strMeasure13.isNotEmpty())
                    ingredients.add("$strIngredient13 ($strMeasure13)")
                else
                    ingredients.add(strIngredient13)
            }
            if (strMeasure14 != null && strIngredient14.isNotEmpty()) {
                if (strMeasure14 != null && strMeasure14.isNotEmpty())
                    ingredients.add("$strIngredient14 ($strMeasure14)")
                else
                    ingredients.add(strIngredient14)
            }
            if (strMeasure15 != null && strIngredient15.isNotEmpty()) {
                if (strMeasure15 != null && strMeasure15.isNotEmpty())
                    ingredients.add("$strIngredient15 ($strMeasure15)")
                else
                    ingredients.add(strIngredient15)
            }
            if (strMeasure16 != null && strIngredient16.isNotEmpty()) {
                if (strMeasure16 != null && strMeasure16.isNotEmpty())
                    ingredients.add("$strIngredient16 ($strMeasure16)")
                else
                    ingredients.add(strIngredient16)
            }
            if (strMeasure17 != null && strIngredient17.isNotEmpty()) {
                if (strMeasure17 != null && strMeasure17.isNotEmpty())
                    ingredients.add("$strIngredient17 ($strMeasure17)")
                else
                    ingredients.add(strIngredient17)
            }
            if (strMeasure18 != null && strIngredient18.isNotEmpty()) {
                if (strMeasure18 != null && strMeasure18.isNotEmpty())
                    ingredients.add("$strIngredient18 ($strMeasure18)")
                else
                    ingredients.add(strIngredient18)
            }
            if (strMeasure19 != null && strIngredient19.isNotEmpty()) {
                if (strMeasure19 != null && strMeasure19.isNotEmpty())
                    ingredients.add("$strIngredient19 ($strMeasure19)")
                else
                    ingredients.add(strIngredient19)
            }
            if (strMeasure20 != null && strIngredient20.isNotEmpty()) {
                if (strMeasure20 != null && strMeasure20.isNotEmpty())
                    ingredients.add("$strIngredient20 ($strMeasure20)")
                else
                    ingredients.add(strIngredient20)
            }
            return ingredients
        }
    }


}