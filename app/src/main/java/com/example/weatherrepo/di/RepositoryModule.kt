package com.example.weatherrepo.di

import com.example.weatherrepo.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


//    @Singleton
//    @Provides
//    fun weatherRepository(): WeatherRepository {
//        return  weatherRepository()
//    }
}