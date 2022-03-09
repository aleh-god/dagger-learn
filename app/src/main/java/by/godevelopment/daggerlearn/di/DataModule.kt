package by.godevelopment.daggerlearn.di

import by.godevelopment.daggerlearn.data.DataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideDataSource(): DataSource {
        return DataSource("I am DataModule")
    }
}