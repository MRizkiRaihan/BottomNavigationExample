package com.mrizkiraihan.bottomnavigationexample.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrizkiraihan.bottomnavigationexample.*


class HomeFragment : Fragment() {


    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MovieAdapter(movieArrayList){
            val intent = Intent(context,DetailMovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    private fun dataInitialize(){
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.abysswatcher,
            R.drawable.godric2,
            R.drawable.hoarah,
            R.drawable.isshin2,
            R.drawable.maria,
            R.drawable.miquella,
            R.drawable.namelessking,
            R.drawable.starcourge,
            R.drawable.radagon,
            R.drawable.soulcinder,

        )
        title = arrayOf(
            getString(R.string.abysswatcher),
            getString(R.string.godric),
            getString(R.string.hoarahloux),
            getString(R.string.isshin),
            getString(R.string.maria),
            getString(R.string.malenia),
            getString(R.string.namelessking),
            getString(R.string.radahn),
            getString(R.string.radagon),
            getString(R.string.soulofcinder),


        )

        description = arrayOf(
            getString(R.string.desc_abysswatcher),
            getString(R.string.desc_godric),
            getString(R.string.desc_hoarahloux),
            getString(R.string.desc_isshin),
            getString(R.string.desc_maria),
            getString(R.string.desc_malenia),
            getString(R.string.desc_namelessking),
            getString(R.string.desc_radahn),
            getString(R.string.desc_radagon),
            getString(R.string.desc_soulofcinder),

        )
        for (i in image.indices){

            val movie = Movie(image[i],title[i], description[i])
            movieArrayList.add(movie)
        }


    }
}