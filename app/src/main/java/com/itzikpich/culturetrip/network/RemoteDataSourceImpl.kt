package com.itzikpich.culturetrip.network

import com.itzikpich.culturetrip.models.ArticlesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.itzikpich.culturetrip.models.Result
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiService: RetrofitService): RemoteDataSource, RetrofitService by apiService {

    override suspend fun getArticles(): Flow<Result<ArticlesResponse>> {
        return flow {
            emit(Result.Loading)
            try {
                val response = getArticlesAsync()
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        emit(Result.Success(it))
                    }
                } else emit(Result.Error(Exception("response not successful")))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(e))
            }
        }
    }

}