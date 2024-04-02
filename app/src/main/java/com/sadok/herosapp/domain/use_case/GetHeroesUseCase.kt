package com.sadok.herosapp.domain.use_case

import com.sadok.herosapp.domain.repository.HeroRepository
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(
    private val repository: HeroRepository
) {
    operator fun invoke() = repository.getHeroes()


}