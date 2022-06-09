package com.teamb.parkingspotfinder.repository

import com.teamb.parkingspotfinder.data.ParkingSpotEntity
import com.teamb.parkingspotfinder.domain.ParkingSpotUiModel
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {

    suspend fun addParkingSpot(parkingSpot: ParkingSpotUiModel)

    fun getParkingSpots(): Flow<List<ParkingSpotUiModel>>

    suspend fun deleteParkingSpot(parkingSpot: ParkingSpotUiModel)
}