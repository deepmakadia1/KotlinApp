package com.kotlinapp.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
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
