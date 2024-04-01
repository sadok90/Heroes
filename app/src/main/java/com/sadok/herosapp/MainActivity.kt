package com.sadok.herosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sadok.herosapp.data.dto.Hero
import com.sadok.herosapp.presentation.listHero.HeroesViewModel
import com.sadok.herosapp.presentation.listHero.component.HeroItem
import com.sadok.herosapp.ui.theme.HerosAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val heroesViewModel: HeroesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HerosAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroesScreen(heroesViewModel)
                }
            }
        }
    }
}

@Composable
fun HeroesScreen(viewModel: HeroesViewModel) {
    if (viewModel.state.value.error.isNotEmpty()) {
        Text(
            modifier =
            Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Red,
            text = viewModel.state.value.error
        )
    } else if (viewModel.state.value.isLoading) {
        ProgressIndicator()
    } else {
        Content(heroes = viewModel.state.value.heroes)
    }
}

@Composable
fun ProgressIndicator() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(32.dp)
        )
    }
}

@Composable
fun Content(heroes: List<Hero>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(heroes) { hero ->
            HeroItem(hero = hero)
        }
    }
}