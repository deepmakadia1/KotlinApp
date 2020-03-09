package com.kotlinapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinapp.R
import com.kotlinapp.adapter.RecipeListAdapter
import com.kotlinapp.databinding.ActivityRecipeListBinding
import com.kotlinapp.model.entity.RecipeListModel
import com.kotlinapp.util.Constants
import com.kotlinapp.viewmodel.RecipeListActivityViewModel

class RecipeListActivity : BaseActivity<ActivityRecipeListBinding,RecipeListActivityViewModel>() {

    private lateinit var recipeListAdapter : RecipeListAdapter
    private var recipeList:ArrayList<RecipeListModel.Meal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.toolbarText?.text = intent.getStringExtra(Constants.RECIPE_CATEGORY_NAME)
        binding?.toolbarText?.let { ViewCompat.setTransitionName(it,Constants.TRANSITION_1) }

        recipeListAdapter = RecipeListAdapter(this,recipeList)
        binding?.recRecipes?.layoutManager = LinearLayoutManager(this)
        binding?.recRecipes?.adapter = recipeListAdapter

        viewModel?.getProgress()?.observe(this, Observer {
            if (it){
                binding?.recRecipes?.visibility = View.GONE
                binding?.progress?.visibility = View.VISIBLE
            }else{
                binding?.recRecipes?.visibility = View.VISIBLE
                binding?.progress?.visibility = View.GONE
            }
        })

        viewModel?.getRecipeList(intent.getStringExtra(Constants.RECIPE_CATEGORY_NAME))?.observe(this,
            Observer {
                setRecyclerView(it)
            })

    }

    private fun setRecyclerView(it: ArrayList<RecipeListModel.Meal>) {
        recipeList.clear()
        recipeList.addAll(it)
        recipeListAdapter.notifyDataSetChanged()
    }

    override fun getLayout(): Int {
        return R.layout.activity_recipe_list
    }

    override fun getViewModel(): Class<RecipeListActivityViewModel> {
        return RecipeListActivityViewModel::class.java
    }
}
