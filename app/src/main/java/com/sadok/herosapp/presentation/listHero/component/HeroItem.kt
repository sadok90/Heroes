package com.sadok.herosapp.presentation.listHero.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sadok.herosapp.data.dto.Hero

@Composable
fun HeroItem(hero: Hero) {
    Card(
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            HeroItemLine(label = "Name", value = hero.name)
            HeroItemLine(label = "LocalizedName", value = hero.localizedName)
            HeroItemLine(label = "Attack Type", value = hero.attackType)
        }
    }

}

@Composable
fun HeroItemLine(label : String, value: String) {
    Row {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}