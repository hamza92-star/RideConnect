package com.rideconnect.app.ui.ride

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AgricultureScreen(
    onServiceClick: (String) -> Unit
) {
    val agricultureServices = listOf(
        "🚜 Tractor",
        "🌾 Rotavator",
        "🌱 Cultivator",
        "🚜 Plough",
        "🌱 Seed Drill",
        "🌿 Sprayer",
        "💧 Water Tanker",
        "🚛 Trailer"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item {
            Text(
                text = "Agriculture Services",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Select tractor or agriculture service",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(agricultureServices) { service ->
            AgricultureServiceCard(
                title = service,
                onClick = {
                    onServiceClick(service)
                }
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun AgricultureServiceCard(
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Tap to continue booking",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}