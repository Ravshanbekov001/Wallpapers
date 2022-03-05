package com.example.wallpapers.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wallpapers.R
import com.example.wallpapers.adapters.ItemClick
import com.example.wallpapers.adapters.ViewPagerAdapter
import com.example.wallpapers.databinding.FragmentMainBinding
import com.example.wallpapers.models.Category
import com.example.wallpapers.models.Images
import com.example.wallpapers.models.Images2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.top_tab_item.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(), ItemClick {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentMainBinding
    lateinit var categoryList: ArrayList<Category>
    lateinit var list: ArrayList<Images>
    lateinit var viewPagerAdapter: ViewPagerAdapter

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

        binding = FragmentMainBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryList = ArrayList()

        categoryList.add(Category("ALL", R.drawable.top_tab_layout_indicator))
        categoryList.add(Category("NEW", R.drawable.top_tab_layout_indicator))
        categoryList.add(Category("ANIMALS", R.drawable.top_tab_layout_indicator))
        categoryList.add(Category("TECHNOLOGY", R.drawable.top_tab_layout_indicator))
        categoryList.add(Category("NATURE", R.drawable.top_tab_layout_indicator))

        binding.menu.setOnClickListener {
            binding.drawerLayout.openDrawer(Gravity.LEFT)
        }

        list = ArrayList()
        list.add(Images(R.drawable.rectangle))
        list.add(Images(R.drawable.rectangle2))
        list.add(Images(R.drawable.rectangle3))
        list.add(Images(R.drawable.rectangle4))
        list.add(Images(R.drawable.rectangle5))
        list.add(Images(R.drawable.rectangle6))
        list.add(Images(R.drawable.rectangle7))
        list.add(Images(R.drawable.rectangle8))
        list.add(Images(R.drawable.rectangle9))
        list.add(Images(R.drawable.rectangle10))
        list.add(Images(R.drawable.rectangle11))
        list.add(Images(R.drawable.rectangle12))

        viewPagerAdapter = ViewPagerAdapter(list, this)
        binding.viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position -> }.attach()


        setTabs()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.tab_item_indicator?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.tab_item_indicator?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.apply {
            home.setOnClickListener {
                title.text = "Home"
                search.setImageResource(R.drawable.ic_search)
            }

            popular.setOnClickListener {
                title.text = "Popular"
                search.setImageResource(R.drawable.ic_popular)
            }

            random.setOnClickListener {
                title.text = "Random"
                search.setImageResource(R.drawable.ic_random)
            }

            liked.setOnClickListener {
                title.text = "My Favourites"
                search.setImageResource(R.drawable.ic_liked)
            }
        }

    }

    private fun setTabs() {
        val tabCount = binding.tabLayout.tabCount

        for (i in 0 until tabCount) {
            val tabItem =
                LayoutInflater.from(this.context).inflate(R.layout.top_tab_item, null, false)
            val tab = tab_layout.getTabAt(i)
            tab?.customView = tabItem

            tabItem.tab_item_text.text = categoryList[i].title

            if (i == 0) {
                tabItem.tab_item_indicator.visibility = View.VISIBLE
            } else {
                tabItem.tab_item_indicator.visibility = View.INVISIBLE
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun itemClick(position: Int, image: Images) {
        findNavController().navigate(R.id.action_mainFragment_to_showImageFragment,
            bundleOf("key" to image))
    }
}