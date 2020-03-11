package com.kotlinapp.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.kotlinapp.R
import com.kotlinapp.databinding.ActivityRecipeBinding
import com.kotlinapp.databinding.ItemIngredientBinding
import com.kotlinapp.util.Constants
import com.kotlinapp.viewmodel.RecipeActivityViewModel

class RecipeActivity : BaseActivity<ActivityRecipeBinding, RecipeActivityViewModel>() {

    private lateinit var videoLink: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.play?.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoLink)))
        }

        binding?.mealName = intent.getStringExtra(Constants.RECIPE_MEAL_NAME)
        binding?.imageUrl = intent.getStringExtra(Constants.RECIPE_MEAL_THUMB)

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

}
