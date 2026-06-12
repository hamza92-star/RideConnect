package com.rideconnect.app.viewmodel

import androidx.lifecycle.ViewModel
import com.rideconnect.app.data.model.Booking
import com.rideconnect.app.data.repository.BookingRepository

class BookingViewModel : ViewModel() {

    private val repository = BookingRepository()

    val bookings: List<Booking>
        get() = repository.bookings

    fun addBooking(serviceName: String) {
        repository.addBooking(serviceName)
    }

    fun updateBookingStatus(bookingId: String) {
        repository.updateBookingStatus(bookingId)
    }
}