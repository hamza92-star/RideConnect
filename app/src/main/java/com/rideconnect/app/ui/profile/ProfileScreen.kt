package com.rideconnect.app.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rideconnect.app.data.model.UserProfile

@Composable
fun ProfileScreen(
    userProfile: UserProfile,
    onSaveProfile: (
        name: String,
        phoneNumber: String,
        city: String,
        language: String
    ) -> Unit
) {
    var name by remember { mutableStateOf(userProfile.name) }
    var phoneNumber by remember { mutableStateOf(userProfile.phoneNumber) }
    var city by remember { mutableStateOf(userProfile.city) }
    var isUrdu by remember { mutableStateOf(userProfile.language == "Urdu") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("City / Area") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Language")

        Switch(
            checked = isUrdu,
            onCheckedChange = { isUrdu = it }
        )

        Text(
            text = if (isUrdu) "Urdu selected" else "English selected"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onSaveProfile(
                    name,
                    phoneNumber,
                    city,
                    if (isUrdu) "Urdu" else "English"
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Profile")
        }
    }
}