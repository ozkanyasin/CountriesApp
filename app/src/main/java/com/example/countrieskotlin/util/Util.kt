package com.example.countrieskotlin.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.countrieskotlin.R

//extension

fun ImageView.downloadFromURL(url: String?, progressDrawable: CircularProgressDrawable){


    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}

fun placeholderProgressBar(contex: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(contex).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

@BindingAdapter("android:downloadUrl")
fun dowloadnImage(view: ImageView, url:String?) {
    view.downloadFromURL(url, placeholderProgressBar(view.context))
}