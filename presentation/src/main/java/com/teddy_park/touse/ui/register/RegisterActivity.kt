package com.teddy_park.touse.ui.register

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.teddy_park.touse.R
import com.teddy_park.touse.base.BaseActivity
import com.teddy_park.touse.databinding.ActivitySplashBinding
import com.teddy_park.touse.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class RegisterActivity : BaseActivity<ActivitySplashBinding, RegisterActivityViewModel>() {

    override val viewModel: RegisterActivityViewModel by viewModels()
    override val layout: Int = R.layout.activity_register



    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {



    }


}