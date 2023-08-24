package com.teddy_park.touse.ui.splash

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
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashActivityViewModel>() {

    override val viewModel: SplashActivityViewModel by viewModels()
    override val layout: Int = R.layout.activity_splash

    private var permissionRequester = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.entries.all { it.value }
        Log.d("박태규", "permissions : $permissions / granted : $granted")
        if (granted) {
            Log.d("박태규", "granted : $granted")
            moveMainActivity()
        } else {
            if (PERMISSIONS.all { shouldShowRequestPermissionRationale(it) }) {
                finish()
            } else {
                Toast.makeText(this, "설정화면에서 권한을 허용해주세요.", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    .setData(Uri.parse("package:${packageName}"))
                startActivity(intent)
                finish()
            }
        }
    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

        if (hasPermissions(PERMISSIONS)) {

            moveMainActivity()
        } else {
            permissionRequester.launch(PERMISSIONS)
        }

    }

    private fun moveMainActivity() {
        Log.d("박태규", "moveMainActivity")
        Handler(Looper.getMainLooper()).postDelayed(
            { val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 1500
        )
    }

    private fun hasPermissions(permissions: Array<String>): Boolean =
        permissions.all {
            ActivityCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }


    companion object {

        var PERMISSIONS = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.POST_NOTIFICATIONS
            )
        } else {
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
    }
}