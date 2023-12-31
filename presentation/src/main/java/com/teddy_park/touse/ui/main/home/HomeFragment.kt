package com.teddy_park.touse.ui.main.home

import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.teddy_park.touse.R
import com.teddy_park.touse.base.BaseFragment
import com.teddy_park.touse.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {

    override val viewModel: HomeFragmentViewModel by viewModels()
    override val layout: Int = R.layout.fragment_home

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {



    }
}