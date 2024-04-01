package com.sadok.herosapp.presentation.listHero

import com.sadok.herosapp.data.dto.Hero

class HeroesState(
    val isLoading: Boolean = false,
    val heroes: List<Hero> = emptyList(),
    val error: String = ""
)