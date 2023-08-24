package com.teddy_park.touse.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentTransaction
import com.teddy_park.touse.R
import com.teddy_park.touse.base.BaseActivity
import com.teddy_park.touse.databinding.ActivityMainBinding
import com.teddy_park.touse.ui.main.home.HomeFragment
import com.teddy_park.touse.ui.main.location.LocationFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override val viewModel: MainActivityViewModel by viewModels()
    override val layout: Int = R.layout.activity_main

    private var homeFragment: HomeFragment? = null
    private var locationFragment: LocationFragment? = null

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        initHomeFragment()
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.bottom_nav_home -> {

                }
                R.id.bottom_nav_town -> {

                }
                R.id.bottom_nav_location -> {
                    showLocationFragment()
                }
                R.id.bottom_nav_chat -> {

                }
                R.id.bottom_nav_mypage -> {

                }
            }
            true
        }
    }

    private fun initHomeFragment() {
        if (homeFragment == null) {
            homeFragment = HomeFragment()
        }
        supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .replace(R.id.fragmentContainerView, homeFragment!!).addToBackStack("homeFragment").commit()
    }

    private fun showHomeFragment() {
        supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .remove(homeFragment!!).commit()

        supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .add(R.id.fragmentContainerView, homeFragment!!).addToBackStack("homeFragment").commit()

    }

    private fun showLocationFragment() {
        if (locationFragment == null) {
            locationFragment = LocationFragment()
        }

        supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .add(R.id.fragmentContainerView, locationFragment!!).addToBackStack("homeFragment").commit()

    }

}