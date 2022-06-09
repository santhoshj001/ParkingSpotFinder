package com.teamb.parkingspotfinder.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MapsViewModel() : ViewModel() {
    var mapState by mutableStateOf(MapState())
}