package com.kotlinapp.di.modules

import com.kotlinapp.ui.RecipeActivity
import com.kotlinapp.ui.RecipeCategoryListActivity
import com.kotlinapp.ui.RecipeListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [RecipeViewModelModule::class])
    abstract fun recipeCategoryListActivity(): RecipeCategoryListActivity

    @ContributesAndroidInjector(modules = [RecipeViewModelModule::class])
    abstract fun recipeListActivity(): RecipeListActivity

    @ContributesAndroidInjector(modules = [RecipeViewModelModule::class])
    abstract fun recipeActivity(): RecipeActivity
}