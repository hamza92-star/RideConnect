package com.rideconnect.app.ui.ride

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BookRideScreen(
    serviceName: String,
    onRequestSubmit: () -> Unit
) {
    val isPassengerService =
        serviceName.contains("Bike") ||
                serviceName.contains("Rickshaw Ride") ||
                serviceName.contains("Passenger") ||
                serviceName.contains("Mini") ||
                serviceName.contains("AC")

    val isGoodsService =
        serviceName.contains("Courier") ||
                serviceName.contains("Goods") ||
                serviceName.contains("Loader") ||
                serviceName.contains("Truck")

    val isAgricultureService =
        serviceName.contains("Tractor") ||
                serviceName.contains("Rotavator") ||
                serviceName.contains("Cultivator") ||
                serviceName.contains("Plough") ||
                serviceName.contains("Seed") ||
                serviceName.contains("Sprayer") ||
                serviceName.contains("Water") ||
                serviceName.contains("Trailer")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Text(
            text = "$serviceName Booking",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Fill the details to request this service.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                when {
                    isPassengerService -> PassengerBookingForm(
                        serviceName = serviceName,
                        onRequestSubmit = onRequestSubmit
                    )

                    isGoodsService -> GoodsBookingForm(
                        serviceName = serviceName,
                        onRequestSubmit = onRequestSubmit
                    )

                    isAgricultureService -> AgricultureBookingForm(
                        serviceName = serviceName,
                        onRequestSubmit = onRequestSubmit
                    )

                    else -> GeneralBookingForm(
                        onRequestSubmit = onRequestSubmit
                    )
                }
            }
        }
    }
}

@Composable
fun PassengerBookingForm(
    serviceName: String,
    onRequestSubmit: () -> Unit
) {
    var pickup by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var passengers by remember { mutableStateOf("") }

    OutlinedTextField(
        value = pickup,
        onValueChange = { pickup = it },
        label = { Text("Pickup Location") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = destination,
        onValueChange = { destination = it },
        label = { Text("Destination") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = passengers,
        onValueChange = { passengers = it },
        label = { Text("Number of Passengers") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = onRequestSubmit,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Request $serviceName")
    }
}

@Composable
fun GoodsBookingForm(
    serviceName: String,
    onRequestSubmit: () -> Unit
) {
    var pickup by remember { mutableStateOf("") }
    var dropoff by remember { mutableStateOf("") }
    var itemDescription by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    OutlinedTextField(
        value = pickup,
        onValueChange = { pickup = it },
        label = { Text("Pickup Location") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = dropoff,
        onValueChange = { dropoff = it },
        label = { Text("Dropoff Location") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = itemDescription,
        onValueChange = { itemDescription = it },
        label = { Text("Item Description") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = weight,
        onValueChange = { weight = it },
        label = { Text("Estimated Weight") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = onRequestSubmit,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Request $serviceName")
    }
}

@Composable
fun AgricultureBookingForm(
    serviceName: String,
    onRequestSubmit: () -> Unit
) {
    var village by remember { mutableStateOf("") }
    var landArea by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    OutlinedTextField(
        value = village,
        onValueChange = { village = it },
        label = { Text("Village / Area") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = landArea,
        onValueChange = { landArea = it },
        label = { Text("Land Area / Work Details") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = date,
        onValueChange = { date = it },
        label = { Text("Required Date") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        value = notes,
        onValueChange = { notes = it },
        label = { Text("Extra Notes") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = onRequestSubmit,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Request $serviceName")
    }
}

@Composable
fun GeneralBookingForm(
    onRequestSubmit: () -> Unit
) {
    var details by remember { mutableStateOf("") }

    OutlinedTextField(
        value = details,
        onValueChange = { details = it },
        label = { Text("Details") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = onRequestSubmit,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Submit Request")
    }
}