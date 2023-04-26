package com.example.jetweatherforecast.screens.repository

import com.example.jetweatherforecast.data.WeatherDAO
import com.example.jetweatherforecast.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDbRepository @Inject constructor(private val weatherDAO: WeatherDAO) {

    fun getFavorites(): Flow<List<Favorite>> = weatherDAO.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDAO.insertFavorite(favorite = favorite)
    suspend fun updateFavorite(favorite: Favorite) = weatherDAO.updateFavorite(favorite = favorite)
    suspend fun deleteAllFavorites() = weatherDAO.deleteAllFavorites()
    suspend fun deleteFavorite(favorite: Favorite) = weatherDAO.deleteFavorite(favorite = favorite)
    suspend fun getFavByID(city: String) = weatherDAO.getFavByID(city = city)

    fun getUnits(): Flow<List<com.example.jetweatherforecast.model.Unit>> = weatherDAO.getUnits()
    suspend fun insertUnit(unit: com.example.jetweatherforecast.model.Unit) =
        weatherDAO.insertUnit(unit = unit)

    suspend fun updateUnit(unit: com.example.jetweatherforecast.model.Unit) =
        weatherDAO.updateUnit(unit = unit)

    suspend fun deleteAllUnits() = weatherDAO.deleteAllUnits()
    suspend fun deleteUnit(unit: com.example.jetweatherforecast.model.Unit) =
        weatherDAO.deleteUnit(unit = unit)

}