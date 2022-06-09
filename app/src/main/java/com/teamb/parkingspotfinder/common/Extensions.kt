package com.teamb.parkingspotfinder.data

import com.teamb.parkingspotfinder.domain.ParkingSpotUiModel

fun ParkingSpotEntity.toParkingSpotModel(): ParkingSpotUiModel {
    return ParkingSpotUiModel(
        latitude = latitude,
        longitude = longitude,
        id = id
    )
}

fun ParkingSpotUiModel.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(
        latitude = latitude,
        longitude = longitude,
        id = id
    )
}