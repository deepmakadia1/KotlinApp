package com.kotlinapp.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.kotlinapp.viewmodel.factory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : DaggerAppCompatActivity() {

    abstract fun getLayout(): Int

    abstract fun getViewModel(): Class<V>

    var binding: T? = null

    var viewModel: V? = null

    @JvmField
    @Inject
    var factory: ViewModelProviderFactory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = this
        binding = DataBindingUtil.setContentView(activity, getLayout())

        viewModel = ViewModelProviders.of(this, factory).get(getViewModel())


    }


}