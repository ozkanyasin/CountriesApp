package com.example.countrieskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.service.CountryDatabase
import kotlinx.coroutines.launch


class DetailViewModel(application: Application) : BaseViewModel(application) {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int){
        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            val country = dao.getCountry(uuid)
            countryLiveData.value = country
        }
    }


}