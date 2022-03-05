package com.example.wallpapers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wallpapers.R
import com.example.wallpapers.databinding.FragmentHeaderBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HeaderFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHeaderBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.apply { 
            line1.setOnClickListener {
                Toast.makeText(requireActivity(), "Clicked", Toast.LENGTH_SHORT).show()
            }
        }
        
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeaderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}