package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
//Glide is used here to load the images
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener{
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter
//Setup the layout manager for the recycler view
//A layout manager is used to set the structure of the item views
//For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
//Add data to the model list in the adapter
        //Instantiate ItemTouchHelper for the swipe to delete callback and
//attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"

                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "kenndy ganteng",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/6u8.jpg"

                 ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "the Cat",
                    "Cuddly assassin",
                "https://cdn2.thecatapi.com/images/MjA5MDgyOQ.jpg"
                 ),

                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "joseph",
                    "Kucing misterius",
                    "https://cdn2.thecatapi.com/images/8np.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/d74.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "camelon",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/dlq.png"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Kucing Sigma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/e64.jpg"

                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "wilmar",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/MjA5MDgyOQ.jpg"
                ),
            )
        )
    }
    private fun showSelectionDialog(cat: CatModel){
        AlertDialog.Builder(this).setTitle("Cat Selected").setMessage("You have selected cat ${cat.name}").setPositiveButton("OK") {_, _ ->}.show()
    }
}