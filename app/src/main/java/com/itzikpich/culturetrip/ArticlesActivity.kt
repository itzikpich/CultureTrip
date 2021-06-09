package com.itzikpich.culturetrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.itzikpich.culturetrip.adapters.ArticleAdapter
import com.itzikpich.culturetrip.databinding.ActivityArticlesBinding
import com.itzikpich.culturetrip.di.components.ArticlesActivitySubComponent
import com.itzikpich.culturetrip.view_models.ArticlesViewModel
import javax.inject.Inject

class ArticlesActivity : AppCompatActivity() {

    val TAG = "ArticlesActivity"

    lateinit var articlesActivitySubComponent: ArticlesActivitySubComponent
    @Inject lateinit var factory: ViewModelProvider.Factory
    val articlesViewModel by viewModels<ArticlesViewModel> {factory}
    lateinit var binding: ActivityArticlesBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        articlesActivitySubComponent = (applicationContext as App).appComponent.articlesActivitySubComponent().create()
        articlesActivitySubComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityArticlesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.articlesRecyclerView

        articlesViewModel.articles.observe(this) { articles ->
            Log.d(TAG, "articles: $articles")
//            val itemDecoration = DividerItemDecoration(binding.root.context, DividerItemDecoration.VERTICAL).apply {
//                ContextCompat.getDrawable(binding.root.context, R.drawable.article_divider)?.let { this.setDrawable(it) }
//            }
//            binding.articlesRecyclerView.addItemDecoration(itemDecoration)
            binding.articlesRecyclerView.adapter = ArticleAdapter().apply {
                submitList(articles)
            }
        }

        articlesViewModel.isLoading.observe(this) { loading ->
            binding.articlesLoader.isVisible = loading
        }
    }
}