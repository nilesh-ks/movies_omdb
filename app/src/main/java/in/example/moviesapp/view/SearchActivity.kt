package `in`.example.moviesapp.view

import `in`.example.moviesapp.R
import `in`.example.moviesapp.adapter.MovieAdapter
import `in`.example.moviesapp.viewModel.SearchActivityViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {
    lateinit var search_progress: ProgressBar
    lateinit var et_search: AppCompatEditText
    lateinit var iv_search: AppCompatImageView
    private lateinit var adapter:MovieAdapter
    private lateinit var  viewModel: SearchActivityViewModel
    private lateinit var rv_Search: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        search_progress=findViewById(R.id.search_progress)
        et_search=findViewById(R.id.et_search)
        rv_Search=findViewById(R.id.rv_search)
        viewModel=ViewModelProvider(this).get(SearchActivityViewModel::class.java)
        iv_search=findViewById(R.id.iv_search)
        iv_search.setOnClickListener{
            if(et_search.text!!.isNotEmpty())
            viewModel.searchLocation(et_search.text.toString())
        }


        viewModel.showProgress.observe(this, Observer {
            if (it)
                search_progress.visibility = View.VISIBLE
            else
                search_progress.visibility = View.GONE
        })

        viewModel.moviesList.observe(this, Observer {
       adapter.setMovieList(it.search)
        })
        adapter= MovieAdapter(this)
        rv_Search.adapter=adapter



    }
}