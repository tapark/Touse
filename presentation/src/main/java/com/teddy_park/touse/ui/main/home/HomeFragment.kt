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

    var timer: Timer? = null


    data class TextLapse(val text: String, val time: Long)

    var prevText = TextLapse("", 0L)

    override fun initView(savedInstanceState: Bundle?) {

        binding.startButton.setOnClickListener { startTimer() }
        binding.stopButton.setOnClickListener { stopTimer() }

        binding.textEditText.addTextChangedListener {
            val inputText = TextLapse(it.toString(), System.currentTimeMillis())
            if (inputText.time >= prevText.time + 1000) {
                stopTimer()
                requestTranslation(inputText.text)
            } else {
                startTimer()
            }
            prevText = inputText
        }

    }

    var requestedText = ""

    private fun startTimer() {
        if (timer == null) {
            timer = kotlin.concurrent.timer(period = 1000L) {

                if (binding.textEditText.text.toString() == requestedText) {
                    stopTimer()
                } else {
                    requestedText = binding.textEditText.text.toString()
                    requestTranslation(requestedText)
                }
            }
        }
    }

    private fun requestTranslation(text: String) {
        activity?.runOnUiThread {
            binding.resultText.text = binding.resultText.text.toString() + "${getLogTime()} : $text\n"
        }
    }

    private fun stopTimer() {
        timer?.cancel()
        timer = null
    }

    private fun getLogTime(): String {
        val dateFormat = SimpleDateFormat("dyyyy.MM.dd HH:MM:ss", Locale.KOREAN)
        return dateFormat.format(System.currentTimeMillis())
    }
}