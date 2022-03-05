package com.example.wallpapers.fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wallpapers.R
import com.example.wallpapers.databinding.FragmentShowImageBinding
import com.example.wallpapers.models.Images

class ShowImageFragment : Fragment() {

    lateinit var bindind: FragmentShowImageBinding
    lateinit var image: Images

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        bindind = FragmentShowImageBinding.inflate(layoutInflater)

        return bindind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = arguments?.getSerializable("key") as Images



        bindind.apply {
            back.setOnClickListener {
                findNavController().popBackStack()
            }

            showImage.setImageResource(image.image!!)
        }

    }


}