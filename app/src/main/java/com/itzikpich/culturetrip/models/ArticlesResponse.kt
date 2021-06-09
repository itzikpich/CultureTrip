package com.itzikpich.culturetrip.models


import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("data")
    val articleList: List<Article?>?
) {
    data class Article(
        @SerializedName("metaData")
        val metaData: MetaData?,
        @SerializedName("id")
        val id: String?, // 16911920427781819001
        @SerializedName("title")
        val title: String?, // 10 Reasons Why You Should Visit Tel Aviv
        @SerializedName("imageUrl")
        val imageUrl: String?, // https://cdn.theculturetrip.com/wp-content/uploads/2017/03/jaffa-old-city-door.jpg
        @SerializedName("isSaved")
        val isSaved: Boolean?, // false
        @SerializedName("isLiked")
        val isLiked: Boolean?, // false
        @SerializedName("likesCount")
        val likesCount: Int?, // 12
        @SerializedName("category")
        val category: String?, // Art
        @SerializedName("author")
        val author: Author?
    ) {
        data class MetaData(
            @SerializedName("creationTime")
            val creationTime: String?, // 2017-04-26T12:02:58.000Z
            @SerializedName("updateTime")
            val updateTime: String? // 2017-06-19T14:27:08.000Z
        )

        data class Author(
            @SerializedName("id")
            val id: String?, // 3571
            @SerializedName("authorName")
            val authorName: String?, // Ben Jakob
            @SerializedName("authorAvatar")
            val authorAvatar: AuthorAvatar?
        ) {
            data class AuthorAvatar(
                @SerializedName("imageUrl")
                val imageUrl: String? // https://0.gravatar.com/avatar/430b63571071ec81d57f3605b59a2508?s=50&d=https://cdn.theculturetrip.com/logo/logo50.png&r=g
            )
        }
    }
}