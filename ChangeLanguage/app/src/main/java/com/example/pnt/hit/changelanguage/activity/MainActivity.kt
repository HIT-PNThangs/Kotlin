package com.example.pnt.hit.changelanguage.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pnt.hit.changelanguage.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private val LANGUAGE = "LANGUAGE"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVietnamese.isEnabled = false
        binding.btnEnglish.isEnabled = true

        when (getLanguageApp()) {
            "en" -> {
                binding.btnVietnamese.isEnabled = true
                binding.btnEnglish.isEnabled = false
            }

            else -> {
                binding.btnVietnamese.isEnabled = false
                binding.btnEnglish.isEnabled = true
            }
        }

        binding.btnEnglish.setOnClickListener {
            setUpLanguage("en")
        }

        binding.btnVietnamese.setOnClickListener {
            setUpLanguage("vi")
        }
    }

    private fun getLanguageApp(): String {
        val sharedPreferences = getSharedPreferences(LANGUAGE, MODE_PRIVATE)
        return sharedPreferences.getString("language", "en").toString()
    }

    private fun setUpLanguage(language: String) {
        val config = resources.configuration

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(Locale(language))
        } else {
            config.locale = Locale(language)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            createConfigurationContext(config)
        }

        resources.updateConfiguration(config, resources.displayMetrics)

        putLanguageToApp(language)

        val intent = Intent(baseContext, MainActivity::class.java)
        finish()
        startActivity(intent)
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }

    private fun putLanguageToApp(language: String) {
        val sharedPreferences = getSharedPreferences(LANGUAGE, MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.putString("language", language)
        edit.apply()
    }
}