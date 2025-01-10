package com.example.detailedarticleviewer


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.detailedarticleviewer.databinding.ItemRowBinding

class CustomAdapterArtikel(var listArtikel : ArrayList<DataArtikel>) : RecyclerView.Adapter<CustomAdapterArtikel.ListViewHolder>() {

    private lateinit var onItemClickedCalllback : OnItemClickCallback

    interface OnItemClickCallback {
        fun itemClicked(data : DataArtikel)
    }

    fun setOnItemClickCallback(onItemClick : OnItemClickCallback) {
        this.onItemClickedCalllback = onItemClick
    }

    //  Mereferensikan item dari view di dalam daftar
    class ListViewHolder(var binding : ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    //  Sebuah wrap untuk mengemas item, dipanggil hanya sekali
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ListViewHolder(binding)
    }

    // get size data
    fun getSizeData() : Int {
        return listArtikel.size
    }

    // Isi rak
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, author, imagePhoto) = listArtikel[position]

        Glide.with(holder.itemView.context)
            .load(imagePhoto)
            .into(holder.binding.itemImageView)

        holder.binding.itemTvTitleCard.text= title
        holder.binding.itemTvAuthorCard.text = author
        holder.binding.itemTvDescriptionCard.text = description

        holder.itemView.setOnClickListener{
            onItemClickedCalllback.itemClicked(listArtikel[holder.adapterPosition])
        }
    }

    //  Hitung item rak
    override fun getItemCount() : Int = listArtikel.size

}