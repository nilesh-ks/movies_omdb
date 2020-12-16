package `in`.example.moviesapp.network

import `in`.example.moviesapp.network.model.MovieDetails
import `in`.example.moviesapp.network.model.Search
import `in`.example.moviesapp.network.model.SearchX
//import example.moviesapp.network.model.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL="http://www.omdbapi.com/"
interface MoviesNetwork {

    @GET("?apikey=be6eb36c")
    fun getMovies(@Query("s")searchString: String): Call<Search>

    @GET("?apikey=be6eb36c")
    fun getMovieDetails(@Query("t")details: String): Call<MovieDetails>

   /* @GET("?type=movie")
    fun getMovies(
        @Query(value = "s") searchString: String, @Query(value = "apiKey")apiKey: String): Call<List<Movies>>*/
   /*@GET("?type=movie")
   fun getMovies(
       @Query(value = "s") searchTitle: String, @Query(value = "apiKey") apiKey: String, @Query(
           value = "page"
       ) pageIndex: Int
   ): Call<List<Search>>*/
}