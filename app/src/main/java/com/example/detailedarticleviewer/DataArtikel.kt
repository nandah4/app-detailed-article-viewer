package com.example.detailedarticleviewer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataArtikel(val title: String, val description : String, val author: String, val imagePhoto: String) : Parcelable