package com.example.countrieskotlin.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.countrieskotlin.model.Country

@Database(entities = arrayOf(Country::class),version = 1)
abstract class CountryDatabase : RoomDatabase(){

    abstract fun countryDao() : CountryDAO

    //singleton

    companion object {           //tüm scopelerden ulaşmak için bir obje oluşturacaksak burada instance objesi oluşturduk

        @Volatile private var instance : CountryDatabase? = null         //farklı threadlerde kullanabilmek için volatile

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){     //buradaki operatör elvis operatörü,
                                                                         // if gibi yoksa locklu kısma geçior varsa instance dönüyor

            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context : Context) = Room.databaseBuilder(
            context.applicationContext, CountryDatabase::class.java,"countrydatabase"
        ).build()

    }

}