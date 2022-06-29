package com.duran.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.duran.travelapp.home.HomeFragment
import com.duran.travelapp.travelPlan.TravelPlanFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val travelPlanFragment = TravelPlanFragment()

        val bottomNaviView = findViewById<BottomNavigationView>(R.id.navigationView)

        replaceFragment(homeFragment)

        bottomNaviView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                }
                R.id.travel_plan -> {
                    replaceFragment(travelPlanFragment)
                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fm_container, fragment)
                commit()
            }
    }
}