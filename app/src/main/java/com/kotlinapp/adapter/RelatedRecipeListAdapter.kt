package com.kotlinapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.kotlinapp.R
import com.kotlinapp.databinding.ItemRelatedRecipeBinding
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.ui.RecipeActivity
import com.kotlinapp.util.Constants
import kotlinx.android.synthetic.main.item_recipe.view.*
import kotlinx.android.synthetic.main.item_related_recipe.view.*

class RelatedRecipeListAdapter(
    private val activity: Activity,
    private val recipes: ArrayList<RecipeListModel.Meal>,
    private val category: String
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_related_recipe, parent, false)
        return RelatedRecipeViewHolder(view, activity, recipes)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val relatedRecipeViewHolder = holder as RelatedRecipeViewHolder
        relatedRecipeViewHolder.itemRelatedRecipeBinding?.recipe = recipes[position]
        relatedRecipeViewHolder.itemRelatedRecipeBinding?.category = category
    }

    private class RelatedRecipeViewHolder(
        itemView: View,
        activity: Activity,
        recipeList: ArrayList<RecipeListModel.Meal>
    ) :
        RecyclerView.ViewHolder(itemView) {
        var itemRelatedRecipeBinding: ItemRelatedRecipeBinding? = DataBindingUtil.bind(itemView)

        init {
            itemView.setOnClickListener {

                val intent = Intent(activity, RecipeActivity::class.java)

                val pair1 = Pair.create<View,String>(itemView.imgRelatedRecipe, Constants.TRANSITION_2)
                val pair2=Pair.create<View,String>(itemView.tvRelatedRecipeName, Constants.TRANSITION_3)

                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    pair1,
                    pair2
                )
                intent.putExtra(Constants.RECIPE_RELATED,getRelatedRecipes(recipeList))
                intent.putExtra(Constants.RECIPE_MEAL_ID, recipeList[adapterPosition].idMeal)
                intent.putExtra(Constants.RECIPE_MEAL_THUMB, recipeList[adapterPosition].strMealThumb)
                intent.putExtra(Constants.RECIPE_MEAL_NAME, recipeList[adapterPosition].strMeal)
                ActivityCompat.startActivity(activity, intent, options.toBundle())
            }
        }

        private fun getRelatedRecipes(recipeList: ArrayList<RecipeListModel.Meal>): String {
            val gson = Gson()
            return gson.toJson(recipeList)
        }
    }

}