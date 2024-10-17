package com.pnt.timer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pnt.hit.timer.R
import com.example.pnt.hit.timer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Timer.OnTimerTickListener {
    private lateinit var binding: ActivityMainBinding

    private var isRecording = false
    private var isPause = false

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timer = Timer(this)

        binding.btStart.setOnClickListener {
            when {
                isPause -> resumeRecorder()
                isRecording -> pauseRecording()
                else -> startRecording()
            }
        }

        binding.btReload.setOnClickListener {
            stop()
        }
    }

    private fun startRecording() {
        isRecording = true
        isPause = false

        timer.start()
        binding.btStart.setImageResource(R.drawable.ic_stop)
    }

    private fun resumeRecorder() {
        isRecording = true
        isPause = false

        timer.start()
        binding.btStart.setImageResource(R.drawable.ic_stop)
    }

    private fun pauseRecording() {
        isRecording = false
        isPause = true

        timer.pause()
        binding.btStart.setImageResource(R.drawable.ic_play)
    }

    @SuppressLint("SetTextI18n")
    private fun stop() {
        isPause = false
        isRecording = false

        binding.btStart.setImageResource(R.drawable.ic_play)

        binding.textView.text = "00:00.00"

        timer.stop()
    }

    override fun onTimerTick(duration: String) {
        binding.textView.text = duration
    }
}