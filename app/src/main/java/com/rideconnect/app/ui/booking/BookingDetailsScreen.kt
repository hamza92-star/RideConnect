package com.rideconnect.app.ui.booking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rideconnect.app.data.model.Booking

@Composable
fun BookingDetailsScreen(
    booking: Booking
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Booking Details",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Service: ${booking.serviceName}")
        Spacer(modifier = Modifier.height(10.dp))

        Text("Status: ${booking.status}")
        Spacer(modifier = Modifier.height(10.dp))

        Text("Booking ID: ${booking.id}")
    }
}