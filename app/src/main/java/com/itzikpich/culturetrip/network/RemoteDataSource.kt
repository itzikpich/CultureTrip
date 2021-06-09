package com.itzikpich.culturetrip.network

import com.itzikpich.culturetrip.models.ArticlesResponse
import kotlinx.coroutines.flow.Flow
import com.itzikpich.culturetrip.models.Result

interface RemoteDataSource {
    
    suspend fun getArticles() : Flow<Result<ArticlesResponse>>
}