package com.example.my_kpm_project.android

import android.app.Application
import com.example.my_kpm_project.android.di.dataBaseModule
import com.example.my_kpm_project.android.di.viewModelModule
import com.example.my_kpm_project.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyKMPApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        val modules = sharedKoinModules + viewModelModule + dataBaseModule

        startKoin {
            androidContext(this@MyKMPApplication)
            modules(modules)
        }
    }
}