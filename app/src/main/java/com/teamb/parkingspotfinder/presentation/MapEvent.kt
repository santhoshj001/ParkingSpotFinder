package com.teamb.parkingspotfinder.presentation

import com.google.android.gms.maps.model.LatLng
import com.teamb.parkingspotfinder.domain.ParkingSpotUiModel

sealed class MapEvent() {
    data class AddMarker(val latLng: LatLng) : MapEvent()
    data class DeleteMarker(val parkingSpotUiModel: ParkingSpotUiModel) : MapEvent()
    object MapLoaded : MapEvent()
}
