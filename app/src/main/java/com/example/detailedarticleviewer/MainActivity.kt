package com.example.detailedarticleviewer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rvMain : RecyclerView;
    private val listData = ArrayList<DataArtikel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rv_hero)
        rvMain.setHasFixedSize(true)

        listData.addAll(getDataArtikel())
        showDataArtikel()
    }

    // Function untuk menambah data ke listData
    private fun getDataArtikel() : ArrayList<DataArtikel> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataAuthor = resources.getStringArray(R.array.data_author)
        val description = resources.getStringArray(R.array.data_description)
        val dataImage = resources.getStringArray(R.array.data_image)

        val rtrnList = ArrayList<DataArtikel>()

        for (i in dataTitle.indices) {
            val dataWithValue = DataArtikel(dataTitle[i], dataAuthor[i], description[i], dataImage[i])

            rtrnList.add(dataWithValue)
        }
        return rtrnList
    }

    // Func untuk menentukan bagaimana list data akan tampil
    private fun showDataArtikel() {
        rvMain.layoutManager = LinearLayoutManager(this)
        val listDataAdapter = CustomAdapterArtikel(listData)

        rvMain.adapter = listDataAdapter
    }
}