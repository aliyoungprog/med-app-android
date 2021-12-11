package com.example.medapp

import android.app.Application
import com.example.medapp.di.repositoryModule
import com.example.medapp.di.useCaseModule
import com.example.medapp.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {

            androidLogger(Level.DEBUG)
            modules(
                listOf(
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

}
