package com.teamb.parkingspotfinder.data

import androidx.room.*
import com.teamb.parkingspotfinder.common.Constants
import kotlinx.coroutines.flow.Flow


@Dao
interface ParkingSpotDao {

    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    fun getParkingSpots(): Flow<List<ParkingSpotEntity>>

    @Delete
    suspend fun delete(spot: ParkingSpotEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spot: ParkingSpotEntity)
}