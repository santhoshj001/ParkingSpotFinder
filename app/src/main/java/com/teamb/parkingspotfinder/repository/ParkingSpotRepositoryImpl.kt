package com.teamb.parkingspotfinder.repository

import com.teamb.parkingspotfinder.data.ParkingSpotDao
import com.teamb.parkingspotfinder.data.toParkingSpotEntity
import com.teamb.parkingspotfinder.data.toParkingSpotModel
import com.teamb.parkingspotfinder.domain.ParkingSpotUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParkingSpotRepositoryImpl(
    private val parkingSpotDao: ParkingSpotDao
) : ParkingSpotRepository {
    override suspend fun addParkingSpot(parkingSpot: ParkingSpotUiModel) {
        parkingSpotDao.insert(parkingSpot.toParkingSpotEntity())
    }

    override fun getParkingSpots(): Flow<List<ParkingSpotUiModel>> {
        return parkingSpotDao.getParkingSpots().map { parkingSpots ->
            parkingSpots.map { parkingSpotEntity ->
                parkingSpotEntity.toParkingSpotModel()
            }
        }
    }

    override suspend fun deleteParkingSpot(parkingSpot: ParkingSpotUiModel) {
        parkingSpotDao.delete(parkingSpot.toParkingSpotEntity())
    }

}