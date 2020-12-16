package `in`.example.moviesapp.network.model


import com.google.gson.annotations.SerializedName
//import example.moviesapp.network.model.SearchX

data class Search(
        @SerializedName("Response")
    val response: String,
        @SerializedName("Search")
    val search: List<SearchX>,
        @SerializedName("totalResults")
    val totalResults: String
)