package com.kotlinapp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlinapp.R
import com.kotlinapp.databinding.ItemRecipeBinding
import com.kotlinapp.model.entity.RecipeListModel

class RecipeListAdapter constructor(
    private val activity: Activity,
    private val recipes: ArrayList<RecipeListModel.Meal>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view,activity,recipes)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val categoryViewHolder = holder as RecipeViewHolder
        categoryViewHolder.itemRecipeBinding?.recipe = recipes[position]
    }

    private class RecipeViewHolder(
        itemView: View,
        activity: Activity,
        categories: ArrayList<RecipeListModel.Meal>
    ) :
        RecyclerView.ViewHolder(itemView) {
        var itemRecipeBinding:ItemRecipeBinding? = DataBindingUtil.bind(itemView)
    }

}