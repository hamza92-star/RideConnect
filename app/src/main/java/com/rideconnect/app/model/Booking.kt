package com.rideconnect.app.model

data class Booking(
    val serviceName: String = "",
    val pickup: String = "",
    val destination: String = "",
    val customerName: String = "",
    val phoneNumber: String = "",
    val bookingDate: Long = System.currentTimeMillis()
)