package com.teddy_park.touse.ui.main.chat

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
class ChatFragment: BaseFragment<FragmentHomeBinding, ChatFragmentViewModel>() {

    override val viewModel: ChatFragmentViewModel by viewModels()
    override val layout: Int = R.layout.fragment_chat

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {



    }
}