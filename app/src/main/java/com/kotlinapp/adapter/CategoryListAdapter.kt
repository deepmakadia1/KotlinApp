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
import com.kotlinapp.R
import com.kotlinapp.databinding.ItemCategoriesBinding
import com.kotlinapp.model.entity.RecipeCategoryModel
import com.kotlinapp.ui.activity.RecipeListActivity
import com.kotlinapp.util.Constants
import kotlinx.android.synthetic.main.item_categories.view.*

class CategoryListAdapter constructor(
    private val activity: Activity,
    private val categories: ArrayList<RecipeCategoryModel.Category>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_categories, parent, false)
        return CategoryViewHolder(view, activity, categories)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val categoryViewHolder = holder as CategoryViewHolder
        categoryViewHolder.itemCategoriesBinding?.category = categories[position]
    }

    private class CategoryViewHolder(
        itemView: View,
        activity: Activity,
        categories: ArrayList<RecipeCategoryModel.Category>
    ) :
        RecyclerView.ViewHolder(itemView) {
        var itemCategoriesBinding: ItemCategoriesBinding? = DataBindingUtil.bind(itemView)

        init {
            itemView.setOnClickListener {
                val intent = Intent(activity, RecipeListActivity::class.java)
                intent.putExtra(
                    Constants.RECIPE_CATEGORY_NAME,
                    categories[adapterPosition].strCategory
                )
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity,
                    Pair(itemView.tvCategory, Constants.TRANSITION_1)
                )
                ActivityCompat.startActivity(activity, intent, options.toBundle())
            }
        }
    }

}