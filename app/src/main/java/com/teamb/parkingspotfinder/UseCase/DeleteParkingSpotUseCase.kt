package com.teamb.parkingspotfinder.UseCase

import com.teamb.parkingspotfinder.domain.ParkingSpotUiModel
import com.teamb.parkingspotfinder.repository.ParkingSpotRepository
import javax.inject.Inject

class DeleteParkingSpotUseCase @Inject constructor(
    private val parkingSpotRepository: ParkingSpotRepository
) {
    suspend operator fun invoke(parkingSpotUiModel: ParkingSpotUiModel) {
        parkingSpotRepository.deleteParkingSpot(parkingSpot = parkingSpotUiModel)
    }
}