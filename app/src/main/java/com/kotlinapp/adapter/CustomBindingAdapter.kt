package com.kotlinapp.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlinapp.R

class CustomBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imageView: ImageView, url: String) {
            val requestOptions = RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
            Glide.with(imageView.context).setDefaultRequestOptions(requestOptions).load(url)
                .into(imageView)
        }
    }

}