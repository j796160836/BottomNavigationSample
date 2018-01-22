package com.johnny.demo.bottomNavigationSample

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.MenuRes
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.johnny.demo.bottomNavigationSample.fragment.Tab01Fragment
import com.johnny.demo.bottomNavigationSample.fragment.Tab02Fragment
import com.johnny.demo.bottomNavigationSample.fragment.Tab03Fragment

class MainActivity : AppCompatActivity() {

    @BindView(R.id.bottom_navigation)
    lateinit var bottomNavigation: BottomNavigationView

    @MenuRes
    private var selectedMenuId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!resources.getBoolean(R.bool.isTablet)) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        ButterKnife.bind(this)

        setupBottomNavigation()
        handleNavigationItemSelected()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("selectedMenuId", selectedMenuId)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState?.getInt("selectedMenuId", -1)?.let {
            handleNavigationItemSelected(it)
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            handleNavigationItemSelected(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun handleNavigationItemSelected(@MenuRes itemId: Int = -1) {
        supportFragmentManager.beginTransaction().apply {
            when (itemId) {
                -1, R.id.tab_01 -> {
                    replace(R.id.fragment_container, Tab01Fragment())
                }
                R.id.tab_02 -> {
                    replace(R.id.fragment_container, Tab02Fragment())
                }
                R.id.tab_03 -> {
                    replace(R.id.fragment_container, Tab03Fragment())
                }
            }
        }.commit()

    }


}
