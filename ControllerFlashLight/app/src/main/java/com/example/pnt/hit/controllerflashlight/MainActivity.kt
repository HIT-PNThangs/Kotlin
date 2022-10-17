package com.example.pnt.hit.controllerflashlight

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.pnt.hit.controllerflashlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var cameraManager: CameraManager
    private var getCameraID: String? = null

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                Toast.makeText(applicationContext, "Devices has no camera", Toast.LENGTH_SHORT)
                    .show()
            } else {
                binding.button.setOnClickListener {
                    on()
                }

                binding.button2.setOnClickListener {
                    off()
                }
            }
        } else {
            Toast.makeText(applicationContext, "Devices has no camera", Toast.LENGTH_SHORT)
                .show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun on() {
        try {
            cameraManager.setTorchMode("0", false)

            Toast.makeText(applicationContext, "Flashlight is turned ON", Toast.LENGTH_SHORT)
                .show()
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun off() {
        try {
            cameraManager.setTorchMode("0", true)

            Toast.makeText(applicationContext, "Flashlight is turned OFF", Toast.LENGTH_SHORT)
                .show()
        } catch (e: CameraAccessException) {

            e.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun finish() {
        super.finish()
        try {
            cameraManager.setTorchMode("0", false)

            Toast.makeText(applicationContext, "Flashlight is turned OFF", Toast.LENGTH_SHORT)
                .show()
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}