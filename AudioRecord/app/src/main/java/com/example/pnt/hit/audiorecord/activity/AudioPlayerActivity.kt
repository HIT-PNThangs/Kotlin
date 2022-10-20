package com.example.pnt.hit.audiorecord.activity

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.media.PlaybackParams
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.pnt.hit.audiorecord.R
import com.example.pnt.hit.audiorecord.databinding.ActivityAudioPlayerBinding
import java.text.DecimalFormat
import java.text.NumberFormat

class AudioPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAudioPlayerBinding

    private lateinit var mediaPlayer: MediaPlayer

    private lateinit var runnable: Runnable
    private lateinit var handler: Handler

    private var delay = 1000L
    private var jumpValue = 5000L
    private var playSpeed = 1.0f

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAudioPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filePath = intent.getStringExtra("filePath")

        mediaPlayer = MediaPlayer()
        mediaPlayer.apply {
            setDataSource(filePath)

            try {
                prepareAsync()
            } catch (e: Exception) {
                Log.e("Audio Player Activity", e.toString())
            }
        }

        val fileName = intent.getStringExtra("fileName")
        binding.fileName.text = fileName

        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            binding.seekBar.progress = mediaPlayer.currentPosition
            binding.tvTrackProgress.text = dateFormat(mediaPlayer.currentPosition)
            handler.postDelayed(runnable, delay)
        }

        binding.back.setOnClickListener {
            onBackPressed()
        }

        binding.btPlay.setOnClickListener {
            playPausePlayer()
        }

        playPausePlayer()

        binding.seekBar.max = mediaPlayer.duration
        binding.tvTrackDuration.text = dateFormat(mediaPlayer.duration)

        mediaPlayer.setOnCompletionListener {
            binding.btPlay.setImageResource(R.drawable.ic_play)
            handler.removeCallbacks(runnable)
        }

        binding.btForward.setOnClickListener {
            mediaPlayer.seekTo((mediaPlayer.currentPosition + jumpValue).toInt())
            binding.seekBar.progress += jumpValue.toInt()
        }

        binding.btReplay.setOnClickListener {
            mediaPlayer.seekTo((mediaPlayer.currentPosition - jumpValue).toInt())
            binding.seekBar.progress -= jumpValue.toInt()
        }

        binding.chip.setOnClickListener {
            if (playSpeed != 2f) playSpeed += 0.5f
            else playSpeed = 0.5f

            binding.chip.text = "x$playSpeed"
            mediaPlayer.playbackParams = PlaybackParams().setSpeed(playSpeed)
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun playPausePlayer() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
            binding.btPlay.setImageResource(R.drawable.ic_pause)
            handler.postDelayed(runnable, delay)
        } else {
            mediaPlayer.pause()
            binding.btPlay.setImageResource(R.drawable.ic_play)
            handler.removeCallbacks(runnable)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()

        mediaPlayer.stop()
        mediaPlayer.release()
        handler.removeCallbacks(runnable)
    }

    private fun dateFormat(duration: Int): String {
        val d = duration / 1000
        val s = d % 60
        val m = (d / 60 % 60)
        val h = ((d - m * 60) / 360)

        val f: NumberFormat = DecimalFormat("00")
        val str = "${f.format(m)}:${f.format(s)}"

        return if (h > 0) "${f.format(h)}:$str" else str
    }
}