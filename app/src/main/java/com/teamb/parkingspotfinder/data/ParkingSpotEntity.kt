package com.teamb.parkingspotfinder.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamb.parkingspotfinder.common.Constants


@Entity(tableName = Constants.TABLE_NAME)
data class ParkingSpotEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val latitude: Double,
    val longitude: Double
)