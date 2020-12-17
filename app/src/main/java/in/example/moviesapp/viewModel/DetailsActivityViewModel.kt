package `in`.example.moviesapp.viewModel

import `in`.example.moviesapp.network.model.MovieDetails
import `in`.example.moviesapp.repository.DetailsActivityRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DetailsActivityViewModel(application: Application): AndroidViewModel(application) {
    private val repository=DetailsActivityRepository(application)
val showProgress: LiveData<Boolean>
    val response:MutableLiveData<MovieDetails>


    init {
        showProgress=repository.showProgress
        response=repository.response
    }
    fun getMovie(title: String)
    {
        repository.getMovie(title)
    }
}