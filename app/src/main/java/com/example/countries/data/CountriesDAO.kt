package com.example.countries.data

import com.example.countries.data.ConstantsFromREST.GET_ALL
import com.example.countries.domain.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountriesDAO {
    @GET(GET_ALL)
    suspend fun getUsersData(): Response<List<Country>>
}