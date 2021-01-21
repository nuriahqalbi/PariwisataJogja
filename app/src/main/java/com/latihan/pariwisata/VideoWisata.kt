package com.latihan.pariwisata

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_video_wisata.*

class VideoWisata : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_wisata)

        //AIzaSyBB6AVyMGUqHODCac6s6uO02Bkg4VeZUIo
        youtubePlayer.initialize("AIzaSyBB6AVyMGUqHODCac6s6uO02Bkg4VeZUIo", this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        p1!!.setFullscreen(true)
        p1.cueVideo("vtu17tC7HDI")
        p1.play()
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        if (p1!!.isUserRecoverableError){
            p1.getErrorDialog(this,1).show()
        }
    }
}