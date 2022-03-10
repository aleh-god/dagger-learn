package by.godevelopment.daggerlearn.di

import by.godevelopment.daggerlearn.data.DataRepositoryImpl
import by.godevelopment.daggerlearn.domain.DataRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindModule {

    @Binds
    abstract fun bind_DataRepository_to_DataRepositoryImpl(
        dataRepository: DataRepositoryImpl
    ): DataRepository
}