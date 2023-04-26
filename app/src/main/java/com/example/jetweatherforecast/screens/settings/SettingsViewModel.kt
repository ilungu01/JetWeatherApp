package com.example.jetweatherforecast.screens.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetweatherforecast.screens.repository.WeatherDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repository: WeatherDbRepository) :
    ViewModel() {
    private val _unitList =
        MutableStateFlow<List<com.example.jetweatherforecast.model.Unit>>(emptyList())
    val unitList = _unitList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUnits().distinctUntilChanged().collect { listOfUnits ->
                if (listOfUnits.isNullOrEmpty()) {
                    Log.d("TAG", "Empty favs")
                } else {
                    _unitList.value = listOfUnits
//                    Log.d("UNIT", ":${unitList.value}")
                }
            }
        }
    }

    fun insertUnit(unit: com.example.jetweatherforecast.model.Unit) = viewModelScope.launch {
        repository.insertUnit(unit = unit)
    }

    fun updateUnit(unit: com.example.jetweatherforecast.model.Unit) = viewModelScope.launch {
        repository.updateUnit(unit = unit)
    }

    fun deleteUnit(unit: com.example.jetweatherforecast.model.Unit) = viewModelScope.launch {
        repository.deleteUnit(unit = unit)
    }

    fun deleteAllUnits() = viewModelScope.launch {
        repository.deleteAllUnits()
    }

}