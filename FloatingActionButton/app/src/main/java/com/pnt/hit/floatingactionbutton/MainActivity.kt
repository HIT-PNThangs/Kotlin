package com.pnt.hit.floatingactionbutton

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pnt.hit.floatingactionbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)
    }

    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)
    }

    private val fromButton: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)
    }

    private val toButton: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)
    }

    private lateinit var binding: ActivityMainBinding
    private var click = false

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            onAddButtonClick()
        }

        binding.btnEdit.setOnClickListener {
            Toast.makeText(this, "Edit button clicked", Toast.LENGTH_LONG).show()
        }

        binding.btnImage.setOnClickListener {
            Toast.makeText(this, "Image button, clicked", Toast.LENGTH_LONG).show()
        }
    }

    private fun onAddButtonClick() {
        setVisibility(click)
        setAnimation(click)
        setClickable(click)
        click = !click
    }

    private fun setAnimation(_click: Boolean) {
        if(!_click) {
            binding.btnEdit.visibility = View.VISIBLE
            binding.btnImage.visibility = View.VISIBLE
        } else {
            binding.btnEdit.visibility = View.INVISIBLE
            binding.btnImage.visibility = View.INVISIBLE
        }
    }

    private fun setVisibility(_click: Boolean) {
        if(!_click) {
            binding.btnEdit.startAnimation(fromButton)
            binding.btnImage.startAnimation(fromButton)
            binding.btnAdd.startAnimation(rotateOpen)
        } else {
            binding.btnEdit.startAnimation(toButton)
            binding.btnImage.startAnimation(toButton)
            binding.btnAdd.startAnimation(rotateClose)
        }
    }

    private fun setClickable(_click: Boolean) {
        if(_click) {
            binding.btnEdit.isClickable = false
            binding.btnImage.isClickable = false
        } else {
            binding.btnEdit.isClickable = true
            binding.btnImage.isClickable = true
        }
    }
}