package by.godevelopment.daggerlearn.di

import dagger.Module

@Module(includes = [DataModule::class, BindModule::class])
class AppModule