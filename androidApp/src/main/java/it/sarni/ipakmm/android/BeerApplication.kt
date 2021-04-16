package it.sarni.ipakmm.android

import android.app.Application
import it.sarni.ipakmm.android.di.appModule
import it.sarni.ipakmm.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BeerApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(appModule).apply {
            androidLogger()
            androidContext(this@BeerApplication)
        }


    }
}