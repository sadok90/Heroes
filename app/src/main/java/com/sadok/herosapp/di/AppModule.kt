package com.sadok.herosapp.di

import com.sadok.herosapp.data.HeroesApi
import com.sadok.herosapp.domain.repository.HeroRepository
import com.sadok.herosapp.domain.repository.HeroRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHeroesApi(): HeroesApi {
        val httpClient = OkHttpClient
            .Builder()
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.opendota.com/api/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HeroesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHeroesRepository(api: HeroesApi): HeroRepository {
        return HeroRepositoryImpl(api)
    }

}