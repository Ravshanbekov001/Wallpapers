package com.example.wallpapers.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpapers.databinding.ItemRvMainBinding
import com.example.wallpapers.models.Images
import com.example.wallpapers.models.Images2
import kotlinx.android.synthetic.main.fragment_show_image.view.*
import kotlinx.android.synthetic.main.item_rv_main.view.*

interface ItemClick {
    fun itemClick(position: Int, image: Images)
}

class ImageAdapter(val list: List<Images>, val itemClick: ItemClick) :
    RecyclerView.Adapter<ImageAdapter.VH>() {

    inner class VH(var itemView: ItemRvMainBinding) : RecyclerView.ViewHolder(itemView.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.itemView.item_image.setImageResource(list[position].image!!)

        holder.itemView.item_image.setOnClickListener {
            itemClick.itemClick(position, list[position])
        }
    }

    override fun getItemCount(): Int = list.size
}