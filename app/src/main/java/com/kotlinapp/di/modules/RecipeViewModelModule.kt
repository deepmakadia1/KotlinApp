package com.kotlinapp.di.modules

import androidx.lifecycle.ViewModel
import com.kotlinapp.di.annotation.ViewModelKey
import com.kotlinapp.model.state.RecipeServiceInterface
import com.kotlinapp.util.Constants
import com.kotlinapp.viewmodel.RecipeCategoryListActivityViewModel
import com.kotlinapp.viewmodel.RecipeListActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Module
abstract class RecipeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipeCategoryListActivityViewModel::class)
    abstract fun providerRecipeCategoryListActivityViewModel(recipeCategoryListActivityViewModel: RecipeCategoryListActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecipeListActivityViewModel::class)
    abstract fun providerRecipeListActivityViewModel(recipeListActivityViewModel: RecipeListActivityViewModel): ViewModel


    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideRecipeRetrofit(
            gsonConverterFactory: GsonConverterFactory?,
            rxJava2CallAdapterFactory: RxJava2CallAdapterFactory?,
            okHttpClient: OkHttpClient?
        ): Retrofit? {
            return Retrofit.Builder()
                .baseUrl(Constants.RECIPE_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build()
        }

        @JvmStatic
        @Provides
        fun provideRecipeServiceInterface(retrofit: Retrofit?): RecipeServiceInterface? {
            return retrofit?.create(RecipeServiceInterface::class.java)
        }
    }
}