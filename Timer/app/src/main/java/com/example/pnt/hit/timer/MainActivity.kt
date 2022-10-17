package com.example.pnt.hit.timer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }

    private fun startRecording() {
        isRecording = true
        isPause = false

        timer.start()
    }

    private fun resumeRecorder() {

        isRecording = true
        isPause = false

        timer.start()
    }

    private fun pauseRecording() {
        isRecording = false
        isPause = true

        timer.pause()
    }

    override fun onTimerTick(duration: String) {
        binding.textView.text = duration
    }
}