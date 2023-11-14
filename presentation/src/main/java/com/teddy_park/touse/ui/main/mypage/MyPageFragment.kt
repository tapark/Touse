package com.teddy_park.touse.ui.main.mypage

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.touse.R
import com.teddy_park.touse.base.BaseFragment
import com.teddy_park.touse.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MyPageFragment: BaseFragment<FragmentHomeBinding, MyPageFragmentViewModel>() {

    override val viewModel: MyPageFragmentViewModel by viewModels()
    override val layout: Int = R.layout.fragment_mypage

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {



    }
}