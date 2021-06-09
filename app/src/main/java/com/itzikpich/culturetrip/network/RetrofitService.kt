package com.itzikpich.culturetrip.network

import com.itzikpich.culturetrip.models.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("home-assignment/response.json")
    suspend fun getArticlesAsync() : Response<ArticlesResponse>

}