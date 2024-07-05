package com.caed.edney

import android.app.Application
import com.caed.edney.di.modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() = startKoin {
        androidContext(this@App)
        modules(modules)
    }
}