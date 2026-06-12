package com.rideconnect.app.ui.ride

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SelectServiceScreen(
    onPassengerClick: () -> Unit,
    onGoodsClick: () -> Unit,
    onAgricultureClick: () -> Unit
) {
    var isUrdu by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (isUrdu) "زبان: اردو" else "Language: English",
                fontWeight = FontWeight.Bold
            )

            Switch(
                checked = isUrdu,
                onCheckedChange = { isUrdu = it }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (isUrdu) "سروس منتخب کریں" else "Select Service",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        ServiceCard(
            title = if (isUrdu) "مسافر ٹرانسپورٹ" else "Passenger Transport",
            subtitle = if (isUrdu) "بائیک، رکشہ، کیری ڈبہ، کار" else "Bike, Rickshaw, Carry Dabba, Car",
            onClick = onPassengerClick
        )

        Spacer(modifier = Modifier.height(14.dp))

        ServiceCard(
            title = if (isUrdu) "سامان کی ترسیل" else "Goods Transport",
            subtitle = if (isUrdu) "کوریئر، لوڈر، سوزوکی، کیری ڈبہ" else "Courier, Loader, Suzuki, Carry Dabba",
            onClick = onGoodsClick
        )

        Spacer(modifier = Modifier.height(14.dp))

        ServiceCard(
            title = if (isUrdu) "زرعی خدمات" else "Agriculture Services",
            subtitle = if (isUrdu) "ٹریکٹر، روٹاویٹر، ہل، سپرے" else "Tractor, Rotavator, Plough, Sprayer",
            onClick = onAgricultureClick
        )
    }
}

@Composable
fun ServiceCard(
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}