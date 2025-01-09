package com.example.detailedarticleviewer

import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.detailedarticleviewer.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_IMAGE_PROFILE = "extra_image_profile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAboutPage)

        binding.toolbarAboutPage.setNavigationOnClickListener {
            finish()
        }

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val profileImage = intent.getStringExtra(EXTRA_IMAGE_PROFILE)

        val tvName : TextView = binding.tvName
        val tvEmail : TextView = binding.tvEmail
        val imageView : ImageView = binding.profileImage

        Glide.with(this)
            .load(profileImage)
            .into(imageView)

        tvName.text = name
        tvEmail.text = email


    }
}