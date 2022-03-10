package by.godevelopment.daggerlearn.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.godevelopment.daggerlearn.di.factory.ViewModelFactory
import by.godevelopment.daggerlearn.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    // Each time we create a new ViewModel, we have to include them in the ViewModelModule so that
    // they can be injected into Android components with the necessary dependencies passed
    // in the constructor.

    @Binds
    abstract fun bindingModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun splashViewModel(viewModel: MainViewModel): ViewModel
}