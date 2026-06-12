package com.rideconnect.app.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.rideconnect.app.data.model.UserProfile

class ProfileViewModel : ViewModel() {

    var userProfile = mutableStateOf(
        UserProfile(
            name = "Hamza",
            phoneNumber = "03XX-XXXXXXX",
            city = "Kahuta",
            language = "English"
        )
    )
        private set

    fun updateProfile(
        name: String,
        phoneNumber: String,
        city: String,
        language: String
    ) {
        userProfile.value = UserProfile(
            name = name,
            phoneNumber = phoneNumber,
            city = city,
            language = language
        )
    }
}