package com.t5application

import android.app.Application
import com.t5application.database.TownRepository

class T5Application : Application() {

    override fun onCreate() {
        super.onCreate()
        TownRepository.initialize(this)
    }

}