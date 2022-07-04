package com.duran.travelapp.config

import android.app.Application
import com.duran.travelapp.repository.AddPlanRepository

class ApplicationClass: Application() {
    override fun onCreate() {
        super.onCreate()

        AddPlanRepository.initialize(this)
    }
}