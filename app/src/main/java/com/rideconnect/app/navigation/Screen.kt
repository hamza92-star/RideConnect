package com.rideconnect.app.navigation

sealed class Screen(val route: String) {

    object Splash : Screen("splash")

    object Welcome : Screen("welcome")

    object Login : Screen("login")

    object Signup : Screen("signup")

    object Home : Screen("home")

    object BookRide : Screen("book_ride/{serviceName}") {
        fun createRoute(serviceName: String): String {
            return "book_ride/$serviceName"
        }
    }

    object SelectService : Screen("selectService")

    object Passenger : Screen("passenger")

    object Goods : Screen("goods")

    object Agriculture : Screen("agriculture")

    object BookingSuccess : Screen("booking_success")

    object MyBookings : Screen("my_bookings")

    object Profile : Screen("profile")

    object SearchingDriver : Screen("searching_driver")

    object BookingDetails : Screen("booking_details/{bookingId}") {
        fun createRoute(bookingId: String): String {
            return "booking_details/$bookingId"
        }
    }

}
