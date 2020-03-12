package com.kotlinapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.kotlinapp.viewmodel.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Suppress("unused")
    @Binds
    abstract fun bindFactory(viewModelProviderFactory: ViewModelProviderFactory):ViewModelProvider.Factory

}