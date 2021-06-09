package com.itzikpich.culturetrip.adapters

import com.itzikpich.culturetrip.models.ArticlesResponse
import com.itzikpich.culturetrip.view_holders.ViewBindingViewHolder
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.itzikpich.culturetrip.R
import com.itzikpich.culturetrip.databinding.ListItemArticleBinding
import com.itzikpich.culturetrip.utilities.loadCircularImage
import com.itzikpich.culturetrip.utilities.loadFromUrlToGlide
import com.itzikpich.culturetrip.utilities.toDate


class ArticleAdapter : androidx.recyclerview.widget.ListAdapter<ArticlesResponse.Article, ViewBindingViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingViewHolder =
        ViewBindingViewHolder.createVH(parent, ListItemArticleBinding::inflate)

    override fun onBindViewHolder(holder: ViewBindingViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            (holder.binding as ListItemArticleBinding).apply {
                articleCategory.text = item.category
                articleImageView.loadFromUrlToGlide(item.imageUrl)
                item.isLiked?.let {
                    articleLikeButton.setImageResource(if (item.isLiked) R.drawable.liked else R.drawable.like)
                }
                item.isSaved?.let {
                    articleSaveButton.setImageResource(if (item.isSaved) R.drawable.saved else R.drawable.save)
                }
                item.likesCount?.let { articleLikesCount.text = it.toString()
                } ?: run {
                    articleLikesCount.text = ""
                }
                articleTitle.text = item.title
                articleWriterName.text = item.author?.authorName
                articlePublishDate.text = item.metaData?.creationTime?.toDate()
                articleWriterImage.loadCircularImage(item.author?.authorAvatar?.imageUrl)
            }
        }
        else Log.e("item is null", "")
    }

    class DiffCallback  : DiffUtil.ItemCallback<ArticlesResponse.Article>() {
        override fun areItemsTheSame(oldItem: ArticlesResponse.Article, newItem: ArticlesResponse.Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArticlesResponse.Article, newItem: ArticlesResponse.Article): Boolean {
            return oldItem == newItem
        }

    }
}