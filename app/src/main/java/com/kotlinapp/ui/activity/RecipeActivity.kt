package com.kotlinapp.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinapp.R
import com.kotlinapp.adapter.IngredientsAdapter
import com.kotlinapp.databinding.ActivityRecipeBinding
import com.kotlinapp.util.Constants
import com.kotlinapp.viewmodel.RecipeActivityViewModel

class RecipeActivity : BaseActivity<ActivityRecipeBinding, RecipeActivityViewModel>() {

    private lateinit var ingredientsAdapter: IngredientsAdapter
    private var ingredients = ArrayList<String?>()
    private lateinit var videoLink: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ingredientsAdapter = IngredientsAdapter(this,ingredients)
        binding?.recIngredients?.layoutManager = LinearLayoutManager(this)
        binding?.recIngredients?.adapter = ingredientsAdapter

        binding?.play?.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoLink)))
        }

        binding?.mealName = intent.getStringExtra(Constants.RECIPE_MEAL_NAME)
        binding?.imageUrl = intent.getStringExtra(Constants.RECIPE_MEAL_THUMB)

        binding?.imgRecipe?.let { ViewCompat.setTransitionName(it,Constants.TRANSITION_2) }
        binding?.tvMeal?.let { ViewCompat.setTransitionName(it,Constants.TRANSITION_3) }

        viewModel?.getMeal(intent.getStringExtra(Constants.RECIPE_MEAL_ID))
            ?.observe(this, Observer {
                binding?.meal = it[0]
                videoLink = it[0].strYoutube
                ingredients.clear()
                ingredients.addAll(it[0].getIngredients())
                ingredientsAdapter.notifyDataSetChanged()
            })

    }

    override fun getLayout(): Int {
        return R.layout.activity_recipe
    }

    override fun getViewModel(): Class<RecipeActivityViewModel> {
        return RecipeActivityViewModel::class.java
    }
}
