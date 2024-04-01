package com.sadok.herosapp.domain.repository

import com.sadok.herosapp.data.dto.Hero

interface HeroRepository {

    suspend fun getHeroes(): List<Hero>
}