package com.kotlinapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kotlinapp.R
import com.kotlinapp.adapter.RelatedRecipeListAdapter
import com.kotlinapp.databinding.ActivityRecipeBinding
import com.kotlinapp.databinding.ItemIngredientBinding
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.util.Constants
import com.kotlinapp.viewmodel.RecipeActivityViewModel
import java.lang.reflect.Type

class RecipeActivity : BaseActivity<ActivityRecipeBinding, RecipeActivityViewModel>() {

    private lateinit var videoLink: String
    private var gson = Gson()
    private var type: Type = object : TypeToken<List<RecipeListModel.Meal>?>() {}.type
    private var recipeList = ArrayList<RecipeListModel.Meal>()
    private lateinit var relatedRecipeListAdapter: RelatedRecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.play?.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoLink)))
        }

        val bundle = intent.extras

        if (bundle!=null){
            recipeList = gson.fromJson(bundle.getString(Constants.RECIPE_RELATED),type)
            binding?.mealName = bundle.getString(Constants.RECIPE_MEAL_NAME)
            binding?.imageUrl = bundle.getString(Constants.RECIPE_MEAL_THUMB)
        }

        binding?.imgRecipe?.let { ViewCompat.setTransitionName(it, Constants.TRANSITION_2) }
        binding?.collapsingToolbar?.let { ViewCompat.setTransitionName(it, Constants.TRANSITION_3) }

    }

    override fun getLayout(): Int {
        return R.layout.activity_recipe
    }

    override fun getViewModel(): Class<RecipeActivityViewModel> {
        return RecipeActivityViewModel::class.java
    }

    private fun addIngredient(ingredient: String) {
        val view: View = LayoutInflater.from(this)
            .inflate(R.layout.item_ingredient, binding?.lnrIngredients, false)
        val itemIngredientBinding: ItemIngredientBinding? = DataBindingUtil.bind(view)
        itemIngredientBinding?.ingredient = ingredient
        binding?.lnrIngredients?.addView(view)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        viewModel?.getMeal(intent.getStringExtra(Constants.RECIPE_MEAL_ID))
            ?.observe(this, Observer {
                
                binding?.meal = it[0]
                videoLink = it[0].strYoutube

                binding?.segmentIngredient?.visibility = View.VISIBLE
                binding?.segmentRecipe?.visibility = View.VISIBLE
                binding?.segmentRelatedRecipes?.visibility = View.VISIBLE

                relatedRecipeListAdapter = RelatedRecipeListAdapter(this,getRelatedRecipes(recipeList),recipeList,it[0].strCategory)
                binding?.recRelatedRecipes?.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
                binding?.recRelatedRecipes?.adapter = relatedRecipeListAdapter

                for (ingredient in it[0].getIngredients()) {
                    if (ingredient != null) {
                        addIngredient(ingredient)
                    }
                }

            })

    }

    override fun onDestroy() {
        binding?.segmentIngredient?.visibility = View.GONE
        super.onDestroy()
    }

    private fun getRelatedRecipes(recipeList: ArrayList<RecipeListModel.Meal>): ArrayList<RecipeListModel.Meal> {
        val refRecipes = ArrayList<RecipeListModel.Meal>()
        refRecipes.addAll(recipeList)
        val relatedRecipes = ArrayList<RecipeListModel.Meal>()
        if (refRecipes.size > 10){
            for (i in 0..9){
                val random = refRecipes.random()
                relatedRecipes.add(random)
                refRecipes.remove(random)
            }
        }else{
            relatedRecipes.addAll(refRecipes)
        }

        return relatedRecipes
    }

}
