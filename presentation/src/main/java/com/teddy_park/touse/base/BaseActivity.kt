package com.teddy_park.touse.base

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.autowini.seller_and.auctionwini.widget.context.ContextUtils
import com.teddy_park.data.preference.PrefManager
import com.teddy_park.data.preference.PrefManager.KEY_APP_LANGUAGE
import com.teddy_park.touse.BR
import java.util.*

abstract class BaseActivity<V: ViewDataBinding, VM: ViewModel>: AppCompatActivity() {

    lateinit var binding: V
    abstract val viewModel: VM
    abstract val layout: Int

    private var progressDialog: AppCompatDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this

        initView(savedInstanceState)
        addObserver()
    }

    abstract fun addObserver()

    abstract fun initView(savedInstanceState: Bundle?)


    override fun attachBaseContext(newBase: Context) {
        var language = PrefManager.getString(KEY_APP_LANGUAGE, "")
        Log.d("박태규", "PrefManager.getAppLanguage : $language")
        if (language.isNullOrEmpty()) {
                language = Locale.getDefault().language
                Log.d("박태규", "Locale.getAppLanguage : $language")
                PrefManager.putString(KEY_APP_LANGUAGE, language)
                super.attachBaseContext(newBase)
            } else {
                val locale = Locale(language)
                val localeUpdatedContext: ContextWrapper = ContextUtils.updateLocale(newBase, locale)
                super.attachBaseContext(localeUpdatedContext)
            }
    }
}