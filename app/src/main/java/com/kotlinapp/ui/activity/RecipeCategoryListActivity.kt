package com.kotlinapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinapp.R
import com.kotlinapp.adapter.CategoryListAdapter
import com.kotlinapp.databinding.ActivityCategoryListActivityBinding
import com.kotlinapp.model.entity.RecipeCategoryModel
import com.kotlinapp.viewmodel.RecipeCategoryListActivityViewModel

class RecipeCategoryListActivity : BaseActivity<ActivityCategoryListActivityBinding,RecipeCategoryListActivityViewModel>() {

    private lateinit var categoryListAdapter: CategoryListAdapter
    private val categoryList = ArrayList<RecipeCategoryModel.Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        categoryListAdapter = CategoryListAdapter(this,categoryList)
        binding?.recRecipes?.layoutManager = LinearLayoutManager(this)
        binding?.recRecipes?.adapter = categoryListAdapter

        viewModel?.getProgress()?.observe(this, Observer {
            if(it){
                binding?.progress?.visibility = View.VISIBLE
                binding?.recRecipes?.visibility = View.GONE
            }else{
                binding?.progress?.visibility = View.GONE
                binding?.recRecipes?.visibility = View.VISIBLE
            }
        })
        viewModel?.getCategories()?.observe(this, Observer { setRecyclerView(it) })


    }

    private fun setRecyclerView(it: ArrayList<RecipeCategoryModel.Category>) {

        categoryList.clear()
        categoryList.addAll(it)
        categoryListAdapter.notifyDataSetChanged()

    }

    override fun getLayout(): Int {
        return R.layout.activity_category_list_activity
    }

    override fun getViewModel(): Class<RecipeCategoryListActivityViewModel> {
        return RecipeCategoryListActivityViewModel::class.java
    }


}
