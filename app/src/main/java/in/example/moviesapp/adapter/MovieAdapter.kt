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
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback


class MovieAdapter( val context: Context) :
        RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var list: List<SearchX> = ArrayList()


    fun setMovieList(list: List<SearchX>){
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle.text = list[position].title
        Picasso.get().load(list[position].poster).into(holder.iv_movie_poster)
       holder.movie_release_date.text=list[position].year
        holder.childView.setOnClickListener {
            Log.d("info", "message")
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("image", list[position].poster)
            intent.putExtra("nameMovie", list[position].title)
            intent.putExtra("yearRelease",list[position].year)

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
       val iv_movie_poster=v.findViewById<ImageView>(R.id.iv_movie_poster)
        val movieTitle=v.findViewById<TextView>(R.id.movie_title)

        val movie_release_date=v.findViewById<TextView>(R.id.movie_release_date)

        var childView=v.findViewById<CardView>(R.id.child)
       // val listView=v.findViewById<LinearLayout>(R.id.listView)
    }

}