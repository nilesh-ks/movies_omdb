package `in`.example.moviesapp.view

import `in`.example.moviesapp.R
import `in`.example.moviesapp.viewModel.DetailsActivityViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailsActivityViewModel
   private lateinit var iv_movie_poster: AppCompatImageView

    private lateinit var  movie_title: TextView

    private lateinit var  movie_release_date: TextView
    private lateinit var  progress_bar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        progress_bar=findViewById(R.id.progress_bar)
        viewModel=ViewModelProvider(this).get(DetailsActivityViewModel::class.java)

        iv_movie_poster=findViewById(R.id.iv_movie_poster)

        movie_title=findViewById(R.id.movie_title)

        movie_release_date=findViewById(R.id.movie_release_date)

        if (intent.hasExtra("image")) {
            val image = intent.getStringExtra("image")
            if (image != null) {
               // viewModel.getMovie(image.toString())
                Picasso.get().load(image).into(iv_movie_poster)
            }
        }

        if (intent.hasExtra("nameMovie")) {
            val title = intent.getStringExtra("nameMovie")
            if (title != null) {
              //  viewModel.getMovie(title)
                movie_title.text=title
            }
        }
        if (intent.hasExtra("yearRelease")) {
            val year = intent.getStringExtra("yearRelease")
            if (year != null) {
                //viewModel.getMovie(year)
                movie_release_date.text=year
            }
        }



        viewModel.showProgress.observe(this, Observer {
            if (it)
                progress_bar.visibility = View.VISIBLE
            else
                progress_bar.visibility = View.GONE
        })

        /*viewModel.response.observe(this,Observer{
            if (it!=null)
                movie_title.text=it.title


        })*/
    }
}