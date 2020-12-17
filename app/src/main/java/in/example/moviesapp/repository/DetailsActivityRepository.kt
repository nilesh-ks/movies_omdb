package `in`.example.moviesapp.repository

import `in`.example.moviesapp.network.BASE_URL
import `in`.example.moviesapp.network.MoviesNetwork
import `in`.example.moviesapp.network.model.MovieDetails
import `in`.example.moviesapp.view.DetailsActivity
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivityRepository(val application: Application) {
val showProgress=MutableLiveData<Boolean>()
    val response=MutableLiveData<MovieDetails>()

    fun getMovie(title: String) {
        showProgress.value = true

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()


        val service=retrofit.create(MoviesNetwork::class.java)
    service.getMovieDetails(title).enqueue(object: Callback<MovieDetails> {
        override fun onResponse(call: Call<MovieDetails>, resp: Response<MovieDetails>) {
            showProgress.value=false
            response.value=resp.body()

        }

        override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
           showProgress.value=false
            Toast.makeText(application,"Error while accessing the API", Toast.LENGTH_SHORT).show()
        }

    })
    }

}