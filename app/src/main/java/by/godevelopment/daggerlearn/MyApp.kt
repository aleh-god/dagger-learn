package by.godevelopment.daggerlearn

import android.app.Application
import android.content.Context
import by.godevelopment.daggerlearn.di.AppComponent
import by.godevelopment.daggerlearn.di.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MyApp -> appComponent
        else -> applicationContext.appComponent
    }