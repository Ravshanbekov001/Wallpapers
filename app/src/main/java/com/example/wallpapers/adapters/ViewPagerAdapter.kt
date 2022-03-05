package com.example.wallpapers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpapers.databinding.FragmentPageBinding
import com.example.wallpapers.models.Images
import kotlinx.android.synthetic.main.fragment_page.view.*

class ViewPagerAdapter(val list: List<Images>, val itemClick: ItemClick) :
    RecyclerView.Adapter<ViewPagerAdapter.VH>() {
    inner class VH(var itemView: FragmentPageBinding) : RecyclerView.ViewHolder(itemView.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(FragmentPageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.recycler_view.adapter = ImageAdapter(list, itemClick)
    }

    override fun getItemCount(): Int = 5
}
