package com.example.countrieskotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrieskotlin.model.Country


class DetailViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("türkiye","asya","ankara","try","türkçe","ww.a.com")
        countryLiveData.value = country
    }


}