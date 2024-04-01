package com.sadok.herosapp.domain.repository

import com.sadok.herosapp.data.HeroesApi
import com.sadok.herosapp.data.dto.Hero
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(private val api: HeroesApi): HeroRepository {

    override suspend fun getHeroes(): List<Hero> {
        return api.listHeroes()
    }

}