package com.kotlinapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinapp.R
import com.kotlinapp.adapter.CategoryListAdapter
import com.kotlinapp.databinding.ActivityRecipeCategoryListBinding
import com.kotlinapp.model.entity.RecipeCategoryModel
import com.kotlinapp.viewmodel.RecipeCategoryListActivityViewModel

class RecipeCategoryListActivity : BaseActivity<ActivityRecipeCategoryListBinding,RecipeCategoryListActivityViewModel>() {

    private lateinit var categoryListAdapter: CategoryListAdapter
    private val categoryList = ArrayList<RecipeCategoryModel.Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        categoryListAdapter = CategoryListAdapter(this,categoryList)
        binding?.recCategories?.layoutManager = LinearLayoutManager(this)
        binding?.recCategories?.adapter = categoryListAdapter

        viewModel?.getProgress()?.observe(this, Observer {
            if(it){
                binding?.progress?.visibility = View.VISIBLE
                binding?.recCategories?.visibility = View.GONE
            }else{
                binding?.progress?.visibility = View.GONE
                binding?.recCategories?.visibility = View.VISIBLE
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
        return R.layout.activity_recipe_category_list
    }

    override fun getViewModel(): Class<RecipeCategoryListActivityViewModel> {
        return RecipeCategoryListActivityViewModel::class.java
    }


}
