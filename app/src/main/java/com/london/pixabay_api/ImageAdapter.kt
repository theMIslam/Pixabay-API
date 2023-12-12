package com.london.pixabay_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.london.pixabay_api.databinding.ItemImageBinding

class ImageAdapter(private val list: List<ImageModel>?): RecyclerView.Adapter<ImageAdapter.ImageViewHolder> (){
    private lateinit var activity: MainActivity
   inner class ImageViewHolder (private val binding: ItemImageBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(imageModel: ImageModel) {
            binding.itemImage.load(imageModel.largeImageURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list!![position])
    }

    override fun getItemCount(): Int {
        return list!!.size
    }
}