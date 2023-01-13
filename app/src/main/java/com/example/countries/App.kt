package com.example.countries

import android.app.Application
import com.example.countries.di.DaggerAppComponent

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        _app = this
    }

    companion object {
        private var _app: App? = null

        val app: App
            get() = _app!!
    }
}
