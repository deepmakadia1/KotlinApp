package com.kotlinapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlinapp.R
import com.kotlinapp.databinding.ItemIngredientBinding
import com.kotlinapp.databinding.ItemRecipeBinding
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.ui.activity.RecipeActivity
import com.kotlinapp.util.Constants

class IngredientsAdapter constructor(
    private val activity: Activity,
    private val ingredients: ArrayList<String?>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_ingredient, parent, false)
        return IngredientViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val ingredientViewHolder= holder as IngredientViewHolder
        ingredientViewHolder.itemIngredientBinding?.ingredient = ingredients[position]
    }

    private class IngredientViewHolder(
        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView) {
        var itemIngredientBinding: ItemIngredientBinding? = DataBindingUtil.bind(itemView)


    }

}