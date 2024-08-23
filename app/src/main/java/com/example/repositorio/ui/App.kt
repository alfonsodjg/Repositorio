package com.example.repositorio.ui

import android.app.Application
import com.example.repositorio.data.core.di.getDataModuleDi
import com.example.repositorio.domain.core.di.getDomainModuleDi
import com.example.repositorio.ui.core.di.getUIModuleDI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                getDataModuleDi(),
                getDomainModuleDi(),
                getUIModuleDI()
            )
        }
    }
}