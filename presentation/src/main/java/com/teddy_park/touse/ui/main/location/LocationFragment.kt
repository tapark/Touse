package com.teddy_park.touse.ui.main.location

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.touse.R
import com.teddy_park.touse.base.BaseFragment
import com.teddy_park.touse.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment: BaseFragment<FragmentLocationBinding, LocationFragmentViewModel>() {

    override val viewModel: LocationFragmentViewModel by viewModels()
    override val layout: Int = R.layout.fragment_location

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}