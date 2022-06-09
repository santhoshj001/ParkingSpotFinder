package com.teamb.parkingspotfinder.presentation

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.teamb.parkingspotfinder.common.MapStyle
import com.teamb.parkingspotfinder.domain.ParkingSpotUiModel

data class MapState(
    val mapProperties: MapProperties = MapProperties(
        mapStyleOptions = MapStyleOptions(MapStyle.STYLE_JSON)
    ),
    val defaultCameraState: CameraPositionState = CameraPositionState(
        position = CameraPosition.fromLatLngZoom(
            LatLng(1.35, 103.87),
            15f
        )
    ),
    val uiSettings: MapUiSettings  = MapUiSettings(),
    val parkingSpots: List<ParkingSpotUiModel> = emptyList()
)
