package com.teamb.parkingspotfinder.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings


@Composable
fun MapScreen(
    viewModel: MapsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val defaultCameraState = remember {
        CameraPositionState(
            position = CameraPosition.fromLatLngZoom(
                LatLng(1.35, 103.87),
                15f
            )
        )
    }
    val uiSetting = remember {
        MapUiSettings(myLocationButtonEnabled = true)
    }
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = defaultCameraState, onMapLoaded = {
                Log.i(" map", "MapScreen: loaded")
            }
        )
    }
}