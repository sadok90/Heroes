package com.sadok.herosapp.domain.repository.use_case

import com.sadok.herosapp.common.Resource
import com.sadok.herosapp.data.dto.Hero
import com.sadok.herosapp.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(
    private val repository: HeroRepository
) {
    operator fun invoke(): Flow<Resource<List<Hero>>> = flow {
        try {
            emit(Resource.Loading())
            val heroes = repository.getHeroes()

            if (heroes.isEmpty()) {
                emit(Resource.Error("No Data found"))
            } else {
                emit(Resource.Success(heroes))
            }
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }

    }
}