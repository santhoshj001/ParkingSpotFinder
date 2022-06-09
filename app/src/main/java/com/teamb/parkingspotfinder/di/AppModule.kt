package com.teamb.parkingspotfinder.di

import android.content.Context
import androidx.room.Room
import com.teamb.parkingspotfinder.UseCase.AddParkingSpotUseCase
import com.teamb.parkingspotfinder.UseCase.DeleteParkingSpotUseCase
import com.teamb.parkingspotfinder.UseCase.GetParkingSpotUseCase
import com.teamb.parkingspotfinder.UseCase.ParkingSpotUseCase
import com.teamb.parkingspotfinder.common.Constants
import com.teamb.parkingspotfinder.data.ParkingSpotDataBase
import com.teamb.parkingspotfinder.repository.ParkingSpotRepository
import com.teamb.parkingspotfinder.repository.ParkingSpotRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ParkingSpotDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = ParkingSpotDataBase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesRepository(database: ParkingSpotDataBase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(database.dao)
    }

    @Provides
    @Singleton
    fun providesParkingSpotUseCase(repository: ParkingSpotRepository): ParkingSpotUseCase {
        return ParkingSpotUseCase(
            addParkingSpotUseCase = AddParkingSpotUseCase(
                parkingSpotRepository = repository
            ), deleteParkingSpotUseCase = DeleteParkingSpotUseCase(
                parkingSpotRepository = repository
            ), getParkingSpotUseCase = GetParkingSpotUseCase(
                parkingSpotRepository = repository
            )
        )
    }
}