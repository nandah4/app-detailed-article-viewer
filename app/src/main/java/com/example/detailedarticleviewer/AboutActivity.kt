package com.example.detailedarticleviewer

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class AboutActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_IMAGE_PROFILE = "extra_image_profile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val profileImage = intent.getStringExtra(EXTRA_IMAGE_PROFILE)

        val tvName : TextView = findViewById(R.id.tv_name)
        val tvEmail : TextView = findViewById(R.id.tv_email)
        val imageView : ImageView = findViewById(R.id.profile_image)

        Glide.with(this)
            .load(profileImage)
            .into(imageView)

        tvName.text = name
        tvEmail.text = email

    }


}