package com.teddy_park.touse.ui.register

import androidx.lifecycle.viewModelScope
import com.teddy_park.domain.usecase.aws_s3.GetS3TokenUseCase
import com.teddy_park.touse.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterActivityViewModel @Inject constructor(
    private val getS3TokenUseCase: GetS3TokenUseCase
): BaseViewModel() {


    fun getS3Token() {
        viewModelScope.launch {
            getS3TokenUseCase.invoke(
                onComplete = {

                },
                onError = {

                },
                onException = {

                }
            ).collect {

            }
        }
    }

}