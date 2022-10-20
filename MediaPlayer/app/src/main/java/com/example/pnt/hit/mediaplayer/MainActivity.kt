package com.example.pnt.hit.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import com.example.pnt.hit.mediaplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var currencySong = mutableListOf(R.raw.audio)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controlSound(currencySong[0])
    }

    private fun controlSound(id: Int) {
        binding.btPlay.setOnClickListener {
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, id)

                initialiseSeekBar()
            }

            mediaPlayer!!.start()
        }

        binding.btPause.setOnClickListener {
            mediaPlayer?.pause()
        }

        binding.btStop.setOnClickListener {
            if(mediaPlayer != null) {
                mediaPlayer!!.stop()
                mediaPlayer!!.reset()
                mediaPlayer!!.release()
                mediaPlayer = null
            }
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2) {
                    mediaPlayer!!.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) { }

            override fun onStopTrackingTouch(p0: SeekBar?) { }
        })
    }

    private fun initialiseSeekBar() {
        binding.seekBar.max = mediaPlayer!!.duration

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    binding.seekBar.progress = mediaPlayer!!.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: java.lang.Exception) {
                    binding.seekBar.progress = 0
                }
            }
        }, 0)
    }
}
