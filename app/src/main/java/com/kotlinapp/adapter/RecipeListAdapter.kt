package com.kotlinapp.adapter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
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
import com.kotlinapp.databinding.ItemRecipeBinding
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.ui.RecipeActivity
import com.kotlinapp.util.Constants
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecipeListAdapter constructor(
    private val activity: Activity,
    private val recipes: ArrayList<RecipeListModel.Meal>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view, activity, recipes)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recipeViewHolder = holder as RecipeViewHolder
        recipeViewHolder.itemRecipeBinding?.recipe = recipes[position]
    }

    private class RecipeViewHolder(
        itemView: View,
        activity: Activity,
        recipeList: ArrayList<RecipeListModel.Meal>
    ) :
        RecyclerView.ViewHolder(itemView) {
        var itemRecipeBinding: ItemRecipeBinding? = DataBindingUtil.bind(itemView)

        init {
            itemView.setOnClickListener {

                val intent = Intent(activity, RecipeActivity::class.java)

                val pair1 = Pair.create<View,String>(itemView.imgRecipe, Constants.TRANSITION_2)
                val pair2=Pair.create<View,String>(itemView.tvRecipeName, Constants.TRANSITION_3)

                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    pair1,
                    pair2
                )
                val bundle = Bundle()
                bundle.putString(Constants.RECIPE_RELATED,getRecipesInString(recipeList))
                bundle.putString(Constants.RECIPE_MEAL_ID, recipeList[adapterPosition].idMeal)
                bundle.putString(Constants.RECIPE_MEAL_THUMB, recipeList[adapterPosition].strMealThumb)
                bundle.putString(Constants.RECIPE_MEAL_NAME, recipeList[adapterPosition].strMeal)

                intent.putExtras(bundle)

                ActivityCompat.startActivity(activity, intent, options.toBundle())
            }
        }

        private fun getRecipesInString(recipeList: ArrayList<RecipeListModel.Meal>):String{
            val gson = Gson()
            return gson.toJson(recipeList)
        }


    }

}