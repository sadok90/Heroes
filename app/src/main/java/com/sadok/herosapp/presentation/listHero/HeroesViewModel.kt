package com.sadok.herosapp.presentation.listHero

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadok.herosapp.common.Resource
import com.sadok.herosapp.domain.repository.use_case.GetHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
   private val getNewsUseCase: GetHeroesUseCase
): ViewModel() {
    private val _state = mutableStateOf(HeroesState())
    val state: State<HeroesState> = _state
    init {
        getHeroes()
    }

    private fun getHeroes() {

        getNewsUseCase().onEach {  result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = HeroesState(heroes = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = HeroesState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = HeroesState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }

}