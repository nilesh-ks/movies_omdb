package `in`.example.moviesapp.viewModel

import `in`.example.moviesapp.network.model.Search
import `in`.example.moviesapp.network.model.SearchX
import `in`.example.moviesapp.repository.SearchActivityRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class SearchActivityViewModel(application: Application): AndroidViewModel(application) {
private val repository=SearchActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val moviesList: LiveData<Search>

    init {
        this.showProgress=repository.showProgress
        this.moviesList=repository.moviesList
    }

    fun changeState(){
        repository.changeState()
    }
    fun searchLocation(searchString: String){
        repository.searchLocation(searchString)
    }
}