package com.kotlinapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModel
import com.kotlinapp.R
import com.kotlinapp.databinding.ActivityRecipeListBinding
import com.kotlinapp.util.Constants
import com.kotlinapp.viewmodel.RecipeListActivityViewModel

class RecipeListActivity : BaseActivity<ActivityRecipeListBinding,RecipeListActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.toolbarText?.text = intent.getStringExtra(Constants.RECIPE_CATEGORY_NAME)
        binding?.toolbarText?.let { ViewCompat.setTransitionName(it,Constants.ADDRESS1_TRANSITION_NAME) }

    }

    override fun getLayout(): Int {
        return R.layout.activity_recipe_list
    }

    override fun getViewModel(): Class<RecipeListActivityViewModel> {
        return RecipeListActivityViewModel::class.java
    }
}
