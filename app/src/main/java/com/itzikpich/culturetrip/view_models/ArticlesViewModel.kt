package com.itzikpich.culturetrip.view_models

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.itzikpich.culturetrip.models.ArticlesResponse
import com.itzikpich.culturetrip.models.Result
import com.itzikpich.culturetrip.network.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


class ArticlesViewModel @Inject constructor(
    app: Application,
    private val repository: Repository): AndroidViewModel(app) {

    val TAG = "ArticlesViewModel"

    val isLoading = MutableLiveData(false)

    val articles : MutableLiveData<List<ArticlesResponse.Article?>> by lazy {
        MutableLiveData<List<ArticlesResponse.Article?>>()
    }

    init {
        getArticles()
    }

    private fun getArticles() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "getArticles: ${Thread.currentThread().name}")
            repository.getArticles().collect { result ->
                when(result) {
                    is Result.Success -> {
                        isLoading.postValue(false)
                        result.data?.articleList?.let {
                            articles.postValue(it)
                        }
                    }
                    is Result.Error -> {
                        isLoading.postValue(false)
                        Log.d(TAG, result.exception.toString())
                    }
                    is Result.Loading -> {
                        isLoading.postValue(true)
                    }
                }
            }

        }
    }

}