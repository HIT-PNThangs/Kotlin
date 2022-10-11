package com.example.pnt.hit.audio.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pnt.hit.audio.R
import com.example.pnt.hit.audio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        onSupportNavigateUp()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.fragment_container) as NavHostFragment
//        navController = navHostFragment.navController
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}