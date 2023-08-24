package com.teddy_park.touse.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teddy_park.touse.widget.event.SingleLiveEvent


abstract class BaseViewModel: ViewModel() {

    val isLoading = MutableLiveData<Boolean>(false)
    private val _backEvent = SingleLiveEvent<Unit>()
    val backEvent:LiveData<Unit> get() = _backEvent

    fun onClickBackEvent() {
        _backEvent.call()
    }
}