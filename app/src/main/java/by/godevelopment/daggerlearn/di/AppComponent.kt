package by.godevelopment.daggerlearn.di

import by.godevelopment.daggerlearn.MainActivity
import by.godevelopment.daggerlearn.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
}