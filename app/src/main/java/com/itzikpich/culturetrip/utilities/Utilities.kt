package com.itzikpich.culturetrip.utilities

import android.graphics.*
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.target.Target
import java.text.SimpleDateFormat
import java.util.*

/**
 * Extension method to load imageView from url.
 */
fun <T> ImageView.loadFromUrlToGlide(model: T, onResourceReady: () -> Unit = {}) {
    GlideApp.with(this)
        .asBitmap()
        .load(model)
        .listener(object : RequestListener<Bitmap> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Bitmap>?,
            isFirstResource: Boolean
        ): Boolean {
            onResourceReady.invoke()
            return false
        }

        override fun onResourceReady(
            resource: Bitmap?,
            model: Any?,
            target: Target<Bitmap>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            onResourceReady.invoke()
            return false
        }
    }).into(this)
}

fun <T> ImageView.loadCircularImage(model: T) {
    GlideApp.with(this)
        .asBitmap()
        .load(model)
        .apply(RequestOptions.circleCropTransform())
        .into(object : BitmapImageViewTarget(this) {
            override fun setResource(resource: Bitmap?) {
                setImageDrawable(
                    resource?.run {
                        RoundedBitmapDrawableFactory.create(resources, this).apply {
                            isCircular = true
                        }
                    }
                )
            }
        })
}

fun String.toDate() : String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val date: Date = dateFormat.parse(this)
    val formatter= SimpleDateFormat("dd MMM, yyyy")
    return formatter.format(date)
}
