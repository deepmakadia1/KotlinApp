package com.kotlinapp.di.modules

import com.kotlinapp.ui.activity.RecipeCategoryListActivity
import com.kotlinapp.ui.activity.RecipeListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [RecipeViewModelModule::class])
    abstract fun recipeCategoryListActivity(): RecipeCategoryListActivity

    @ContributesAndroidInjector(modules = [RecipeViewModelModule::class])
    abstract fun recipeListActivity(): RecipeListActivity

}