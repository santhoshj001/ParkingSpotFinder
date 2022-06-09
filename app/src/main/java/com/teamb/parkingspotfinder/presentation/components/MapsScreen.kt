package com.teamb.parkingspotfinder.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberMarkerState


@Composable
fun MapScreen(
    viewModel: MapsViewModel = hiltViewModel()
) {
    val state = viewModel.mapState
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = state.defaultCameraState,
            onMapLoaded = {
                viewModel.onEvent(MapEvent.MapLoaded)
            },
            uiSettings = state.uiSettings,
            onMapLongClick = { position ->
                viewModel.onEvent(MapEvent.AddMarker(position))
            },
            properties = state.mapProperties
        ) {
            viewModel.mapState.parkingSpots.forEach { spot ->
                Marker(
                    state = MarkerState(position = LatLng(
                        spot.latitude,
                        spot.longitude)
                    ),
                    alpha = 1f,
                    draggable = false,
                    flat = false,
                    snippet = " long Press to Delete  ",
                    tag = " car",
                    title = " Parking Spot",
                    visible = true,
                    onClick = { marker ->
                        marker.showInfoWindow()
                        true
                    },
                    onInfoWindowLongClick = { marker ->
                        marker.hideInfoWindow()
                        viewModel.onEvent(MapEvent.DeleteMarker(spot))
                    },
                    icon = BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_AZURE
                    )

                )
            }
        }
    }
}