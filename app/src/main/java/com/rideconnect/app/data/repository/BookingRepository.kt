package com.rideconnect.app.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.rideconnect.app.data.model.Booking

class BookingRepository {

    private val _bookings = mutableStateListOf<Booking>()

    val bookings: List<Booking>
        get() = _bookings

    fun addBooking(serviceName: String) {
        val booking = Booking(
            id = System.currentTimeMillis().toString(),
            serviceName = serviceName,
            status = "Pending"
        )

        _bookings.add(booking)
    }

    fun updateBookingStatus(bookingId: String) {
        val index = _bookings.indexOfFirst { it.id == bookingId }

        if (index != -1) {
            val currentBooking = _bookings[index]

            val newStatus = when (currentBooking.status) {
                "Pending" -> "Accepted"
                "Accepted" -> "On The Way"
                "On The Way" -> "Completed"
                else -> "Completed"
            }

            _bookings[index] = currentBooking.copy(status = newStatus)
        }
    }
}