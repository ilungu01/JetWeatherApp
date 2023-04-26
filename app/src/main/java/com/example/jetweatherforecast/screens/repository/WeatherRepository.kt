package com.example.jetweatherforecast.screens.repository

import android.util.Log
import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.model.WeatherObject
import com.example.jetweatherforecast.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherAPI) {

    suspend fun getWeather(
        cityQuery: String,
        units: String = "imperial"
    ): DataOrException<Weather, Boolean, Exception> {
        val response =
            try {
                api.getWeather(query = cityQuery, units = units)
            }catch (exception: Exception){
                return DataOrException(exception = exception)
            }
        return DataOrException(data = response)
    }

}