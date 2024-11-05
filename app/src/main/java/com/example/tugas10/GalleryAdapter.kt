package com.example.tugas10

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas10.databinding.ItemGalleryBinding
import com.squareup.picasso.Picasso

class GalleryAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<GalleryAdapter.GridItemViewHolder>() {
    inner class GridItemViewHolder(private val itemBinding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: String, position: Int) {
            with(itemBinding) {
                Picasso.get().load(item).into(itemImg)
                itemTitle.text = "Image ${position + 1}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridItemViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridItemViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}