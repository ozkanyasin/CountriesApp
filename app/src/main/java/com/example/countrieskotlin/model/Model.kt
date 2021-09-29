package com.example.countrieskotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val countryName: String?,

    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    val countryCapital: String?,

    @ColumnInfo(name = "region")
    @SerializedName("region")
    val countryRegion: String?,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    val countryCurrency: String?,

    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val imageUrl: String?,

    @ColumnInfo(name = "language")
    @SerializedName("language")
    val countryLanguage: String?){      //her model oluşturulduğunda pk oluşturmamak için constructor içine değil
                                        //fonksiyon bodysi içine pkyı tanımlıyoruz ama neden ??
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}

