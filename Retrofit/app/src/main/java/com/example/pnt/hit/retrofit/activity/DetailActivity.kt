package com.example.pnt.hit.retrofit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pnt.hit.retrofit.databinding.ActivityDetailBinding
import com.example.pnt.hit.retrofit.model.Photo
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photo = intent.getParcelableExtra<Photo>("photo")
        binding.tvIdDetail.text = "${photo?.id}"
        binding.tvUrlDetail.text = photo?.url
        binding.tvTitleDetail.text = photo?.title
        Picasso.get().load(photo?.url).into(binding.imageDetail)
    }
}