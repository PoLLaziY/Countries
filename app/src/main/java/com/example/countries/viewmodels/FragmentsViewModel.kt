package com.example.countries.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.App
import com.example.countries.domain.Country
import kotlinx.coroutines.launch

class FragmentsViewModel(): ViewModel() {
    private val webService by lazy {
        App.app.appComponent.webService
    }

    private val _countries = MutableLiveData<List<Country>?>(emptyList())
    val countries: LiveData<List<Country>?> get() = _countries

    private val _isRefresh = MutableLiveData(true)
    val isRefresh: LiveData<Boolean> get() = _isRefresh

    val openedItem = MutableLiveData(0)

    init {
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch {
            _isRefresh.postValue(true)
            val countries = webService.getAllCountries()
            _isRefresh.postValue(false)
            _countries.postValue(countries)
        }
    }

}