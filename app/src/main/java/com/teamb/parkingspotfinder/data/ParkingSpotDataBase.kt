package com.teamb.parkingspotfinder.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [ParkingSpotEntity::class],
    version = 1
)
abstract class ParkingSpotDataBase : RoomDatabase() {

    abstract val dao: ParkingSpotDao
}