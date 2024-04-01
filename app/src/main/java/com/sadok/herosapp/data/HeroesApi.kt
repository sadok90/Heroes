package com.sadok.herosapp.data

import com.sadok.herosapp.data.dto.Hero
import retrofit2.http.GET


interface HeroesApi {
    @GET("heroes/")
    suspend fun listHeroes(): List<Hero>
}