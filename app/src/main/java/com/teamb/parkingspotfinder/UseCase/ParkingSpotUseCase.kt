package com.teamb.parkingspotfinder.UseCase

data class ParkingSpotUseCase(
    val addParkingSpotUseCase: AddParkingSpotUseCase,
    val deleteParkingSpotUseCase: DeleteParkingSpotUseCase,
    val getParkingSpotUseCase: GetParkingSpotUseCase
)
