package com.example.detailedarticleviewer

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.detailedarticleviewer.databinding.ActivityDetailArticleBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailArticleBinding

    companion object {
        const val EXTRA_OBJECT = "extra_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarDetail.setNavigationOnClickListener {
            finish()
        }

        val data = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<DataArtikel>(EXTRA_OBJECT, DataArtikel::class.java )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_OBJECT)
        }

        if(data != null) {
            binding.tvTitleDetail.text = data.title
            binding.tvDescriptionDetail.text = data.description
            binding.tvAuthorDetail.text = data.author
            Glide.with(this)
                .load(data.imagePhoto)
                .into(binding.detailImage)
        }
    }
}