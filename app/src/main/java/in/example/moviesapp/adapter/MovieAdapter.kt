package `in`.example.moviesapp.adapter

import `in`.example.moviesapp.R
import `in`.example.moviesapp.network.model.Search
import `in`.example.moviesapp.network.model.SearchX
import `in`.example.moviesapp.view.DetailsActivity
import android.content.Context
import android.content.Intent
import android.location.Location
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback


class MovieAdapter( val context: Context,var list: List<SearchX> = ArrayList()) :
        RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    private  lateinit var iv_movie_poster: ImageView
    private lateinit var movie_title: TextView
    private lateinit var  movie_rated: TextView
    private lateinit var movie_release_date: TextView
    private lateinit var movie_rating: TextView
    private lateinit var movie_runtime: TextView
    private lateinit var  movie_overview: TextView

    fun setMovieList(list: List<SearchX>){
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ///holder.movieTitle.text = list[position].title
       // holder.iv_movie_poster = list[position].poster
       // holder.movie_rated.text=list[position].type
       // holder.movie_release_date.text=list[position].year
        holder.childView.setOnClickListener {
            Log.d("info", "message")
            val intent = Intent(context, DetailsActivity::class.java)
            //intent.putExtra("name", list[position].title)
            context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.activity_single_movie,
                        parent,
                        false

                )

        )
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
       // var iv_movie_poster=v.findViewById<ImageView>(R.id.iv_movie_poster)
        val movieTitle=v.findViewById<TextView>(R.id.movie_title)
        val movie_rated=v.findViewById<TextView>(R.id.movie_rated)
        val movie_release_date=v.findViewById<TextView>(R.id.movie_release_date)
       val movie_rating=v.findViewById<TextView>(R.id.movie_rating)
      val  movie_runtime=v.findViewById<TextView>(R.id.movie_runtime)
       val movie_overview=v.findViewById<TextView>(R.id.movie_overview)
        var childView=v.findViewById<CardView>(R.id.childView)
       // val listView=v.findViewById<LinearLayout>(R.id.listView)
    }

}