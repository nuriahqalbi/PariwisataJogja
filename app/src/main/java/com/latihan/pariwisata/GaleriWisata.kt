package com.latihan.pariwisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GaleriWisata : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var lm: RecyclerView.LayoutManager
    lateinit var adapter: GaleriAdapter
    val url = arrayOf("https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/21/978617/content_images/670x335/20191201161042-8-pantai-pok-tunggal-003-tantri-setyorini.jpg",
    "https://cdns.klimg.com/merdeka.com/i/w/foto/2018/05/21/498134/t/pantai-nglambor-001-tantri-setyorini.jpg",
    "https://cdns.klimg.com/merdeka.com/i/w/foto/2018/05/21/498132/t/the-world-landmarks-merapi-park-001-tantri-setyorini.jpg",
    "https://cdns.klimg.com/merdeka.com/i/w/foto/2018/05/21/498147/t/jogja-bay-waterpark-001-tantri-setyorini.jpg",
    "https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/21/978617/content_images/670x335/20191201154539-4-kebun-teh-nglinggo-002-tantri-setyorini.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeri_wisata)
        recyclerView =  findViewById(R.id.recyclerViewGaleri)
        recyclerView.setHasFixedSize(true)
        lm = GridLayoutManager(this, 2)
        recyclerView.layoutManager = lm

        adapter = GaleriAdapter(url, this)
        recyclerView.adapter = adapter

    }
}