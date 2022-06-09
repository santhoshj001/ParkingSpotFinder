package com.teamb.parkingspotfinder.UseCase

import com.teamb.parkingspotfinder.repository.ParkingSpotRepository
import javax.inject.Inject

class GetParkingSpotUseCase @Inject constructor(
    private val parkingSpotRepository: ParkingSpotRepository
) {
    operator fun invoke() = parkingSpotRepository.getParkingSpots()
}