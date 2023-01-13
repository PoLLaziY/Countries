package com.example.countries.data

import com.example.countries.domain.Country

interface CountriesWebService {
    suspend fun getAllCountries(): List<Country>?
}

class CountriesWebServiceImpl(private val dao: CountriesDAO) : CountriesWebService {
    override suspend fun getAllCountries(): List<Country>? {
        return try {
            dao.getUsersData().body()
        } catch (e: Exception) {
            null
        }
    }
}