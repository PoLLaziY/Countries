package com.example.countries.di

import com.example.countries.data.ConstantsFromREST
import com.example.countries.data.CountriesDAO
import com.example.countries.data.CountriesWebService
import com.example.countries.data.CountriesWebServiceImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideCountiesWebService(dao: CountriesDAO): CountriesWebService =
        CountriesWebServiceImpl(dao)

    @Singleton
    @Provides
    fun provideCountriesDAO(retrofit: Retrofit): CountriesDAO =
        retrofit.create(CountriesDAO::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(ConstantsFromREST.REST_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
}