package com.example.countrieskotlin.service

import com.example.countrieskotlin.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {
    // 20210927193522
    // https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries() : Single<List<Country>>

}