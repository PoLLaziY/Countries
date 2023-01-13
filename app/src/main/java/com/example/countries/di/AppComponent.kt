package com.example.countries.di

import com.example.countries.data.CountriesWebService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
abstract class AppComponent {
    abstract val webService: CountriesWebService
}