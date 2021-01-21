package com.latihan.pariwisata

import android.content.Intent
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var fm : FragmentManager
    lateinit var ft : FragmentTransaction

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val sampleImages = intArrayOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5,
        R.drawable.image_6,
        R.drawable.image_7
    )
//    Carousel
    private val imageListener: ImageListener =
    ImageListener {position, imageView -> Glide.with(this@MainActivity).load(sampleImages[position]).into(imageView) }

    // Android life cycle:
    // onCreate(), life cycle pertama kali di jalankan
    // onStart(), onResume(), onStop(), onDestroy()
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // untuk memanggil activity
        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        carousel
        carouseView.pageCount = 7
        carouseView.setImageListener(imageListener)

        toolbar.visibility = View.VISIBLE


//        fm = supportFragmentManager
//        ft = fm.beginTransaction()
//        ft.replace(R.id.container, Home()).commit()
        btn_profil.setOnClickListener {
            startActivity(Intent(this, ProfilWisata::class.java))
        }

        btn_portal.setOnClickListener {
            startActivity(Intent(this, PortalWisata::class.java))
        }

        btn_lokasi.setOnClickListener {
            startActivity(Intent(this, LokasiWisata::class.java))
        }

        btn_video.setOnClickListener {
            startActivity(Intent(this, VideoWisata::class.java))
        }

        btn_galeri.setOnClickListener {
            startActivity(Intent(this, GaleriWisata::class.java))
        }

        btn_about.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
//                fm = supportFragmentManager
//                ft = fm.beginTransaction()
//                ft.replace(R.id.container, Home()).addToBackStack(null).commit()
            }
            R.id.nav_profil -> {
                startActivity(Intent(this, ProfilWisata::class.java))
            }
            R.id.nav_portal -> {
                startActivity(Intent(this, PortalWisata::class.java))
            }
            R.id.nav_video -> {
                startActivity(Intent(this, VideoWisata::class.java))
            }
            R.id.nav_lokasi -> {
                startActivity(Intent(this, LokasiWisata::class.java))
            }
            R.id.nav_galeri -> {
                startActivity(Intent(this, GaleriWisata::class.java))
            }
            R.id.nav_tentang -> {
                startActivity(Intent(this, About::class.java))
            }
            R.id.nav_keluar -> {
                finish()
            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
