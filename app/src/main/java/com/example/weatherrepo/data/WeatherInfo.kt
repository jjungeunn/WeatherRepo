package com.example.weatherrepo.data

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class WeatherInfo(
    @SerializedName("cod")
    val cod: String,
    @SerializedName("message")
    val message: Int,
    @SerializedName("list")
    val list: List<WeatherDetail>,
) : Parcelable {
    @Parcelize
    data class WeatherDetail(
        @SerializedName("dt")
        val dt: Int,
        @SerializedName("main")
        val main: Main,
        @SerializedName("weather")
        val weather: List<Weather>,
        @SerializedName("dt_txt")
        val dt_txt: String,
        val type : Int

        ) : Parcelable

    @Parcelize
    data class Main(
        @SerializedName("temp_max")
        val temp_max: Double,
        @SerializedName("temp_min")
        val temp_min: Double
    ) : Parcelable

    @Parcelize
    data class Weather(
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("main")
        val main: String
    ) : Parcelable

    companion object {
        const val SEOUL_TYPE = 0
        const val LONDON_TYPE = 0
    }
}