package com.teamb.parkingspotfinder.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.parkingspotfinder.UseCase.ParkingSpotUseCase
import com.teamb.parkingspotfinder.domain.ParkingSpotUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MapsViewModel @Inject constructor(
    private val parkingSpotUseCase: ParkingSpotUseCase
) : ViewModel() {
    var mapState by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            parkingSpotUseCase.getParkingSpotUseCase.invoke().collectLatest { spots ->
                Timber.i(" size is " + spots.size)
                mapState = mapState.copy(
                    parkingSpots = spots
                )
            }
        }
    }


    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.AddMarker -> {
                viewModelScope.launch {
                    parkingSpotUseCase.addParkingSpotUseCase.invoke(
                        ParkingSpotUiModel(
                            latitude = event.latLng.latitude,
                            longitude = event.latLng.longitude,
                        )
                    )
                }
            }
            is MapEvent.MapLoaded -> {
                Log.i("loading", "onEvent: loaded ")
            }
            is MapEvent.DeleteMarker -> {
                viewModelScope.launch {
                    parkingSpotUseCase.deleteParkingSpotUseCase.invoke(
                        event.parkingSpotUiModel
                    )
                }
            }
        }
    }

}