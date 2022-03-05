package com.example.wallpapers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallpapers.R
import com.example.wallpapers.adapters.ImageAdapter
import com.example.wallpapers.adapters.ItemClick
import com.example.wallpapers.databinding.FragmentPageBinding
import com.example.wallpapers.databinding.FragmentShowImageBinding
import com.example.wallpapers.models.Images

class PageFragment : Fragment(), ItemClick {

    lateinit var binding: FragmentPageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentPageBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun itemClick(position: Int, image: Images) {

    }


}