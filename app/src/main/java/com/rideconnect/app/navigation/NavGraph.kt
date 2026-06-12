package com.rideconnect.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rideconnect.app.ui.booking.BookingSuccessScreen
import com.rideconnect.app.ui.booking.MyBookingsScreen
import com.rideconnect.app.ui.components.BottomNavBar
import com.rideconnect.app.ui.home.HomeScreen
import com.rideconnect.app.ui.login.LoginScreen
import com.rideconnect.app.ui.profile.ProfileScreen
import com.rideconnect.app.ui.ride.AgricultureScreen
import com.rideconnect.app.ui.ride.BookRideScreen
import com.rideconnect.app.ui.ride.GoodsScreen
import com.rideconnect.app.ui.ride.PassengerScreen
import com.rideconnect.app.ui.ride.SelectServiceScreen
import com.rideconnect.app.ui.splash.SplashScreen
import com.rideconnect.app.ui.welcome.WelcomeScreen
import com.rideconnect.app.viewmodel.BookingViewModel
import com.rideconnect.app.ui.booking.BookingDetailsScreen
import com.rideconnect.app.viewmodel.ProfileViewModel
import com.rideconnect.app.ui.ride.SearchingDriverScreen
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val bookingViewModel: BookingViewModel = viewModel()
    val profileViewModel: ProfileViewModel = viewModel()

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route

    val bottomRoutes = listOf(
        Screen.Home.route,
        Screen.MyBookings.route,
        Screen.Profile.route
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomRoutes) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(Screen.Splash.route) {
                SplashScreen(
                    onSplashFinished = {
                        navController.navigate(Screen.Welcome.route) {
                            popUpTo(Screen.Splash.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }


            composable(Screen.Welcome.route) {
                WelcomeScreen(
                    onCustomerClick = {
                        navController.navigate(Screen.Login.route)
                    },
                    onDriverClick = {
                        navController.navigate(Screen.Login.route)
                    }
                )
            }

            composable(Screen.Login.route) {
                LoginScreen(
                    onLoginClick = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Login.route) {
                                inclusive = true
                            }
                        }
                    },
                    onSignupClick = {
                        navController.navigate(Screen.Signup.route)
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen(
                    onBookRideClick = {
                        navController.navigate(Screen.SearchingDriver.route)


                    }
                )
            }

            composable(Screen.SelectService.route) {
                SelectServiceScreen(
                    onPassengerClick = {
                        navController.navigate(Screen.Passenger.route)
                    },
                    onGoodsClick = {
                        navController.navigate(Screen.Goods.route)
                    },
                    onAgricultureClick = {
                        navController.navigate(Screen.Agriculture.route)
                    }
                )
            }

            composable(Screen.Passenger.route) {
                PassengerScreen(
                    onServiceClick = { service ->
                        navController.navigate(Screen.BookRide.createRoute(service))
                    }
                )
            }

            composable(Screen.Goods.route) {
                GoodsScreen(
                    onServiceClick = { service ->
                        navController.navigate(Screen.BookRide.createRoute(service))
                    }
                )
            }

            composable(Screen.Agriculture.route) {
                AgricultureScreen(
                    onServiceClick = { service ->
                        navController.navigate(Screen.BookRide.createRoute(service))
                    }
                )
            }

            composable(
                route = Screen.BookRide.route,
                arguments = listOf(
                    navArgument("serviceName") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->

                val serviceName =
                    backStackEntry.arguments?.getString("serviceName") ?: "Ride"

                BookRideScreen(
                    serviceName = serviceName,
                    onRequestSubmit = {
                        bookingViewModel.addBooking(serviceName)
                        navController.navigate(Screen.BookingSuccess.route)
                    }
                )
            }

            composable(Screen.BookingSuccess.route) {
                BookingSuccessScreen(
                    onBackToHomeClick = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(Screen.SearchingDriver.route) {

                SearchingDriverScreen(
                    onCancelClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(
                route = Screen.BookingDetails.route,
                arguments = listOf(
                    navArgument("bookingId") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->

                val bookingId =
                    backStackEntry.arguments?.getString("bookingId") ?: ""

                val booking =
                    bookingViewModel.bookings.find { it.id == bookingId }

                if (booking != null) {
                    BookingDetailsScreen(booking = booking)
                }
            }

            composable(Screen.MyBookings.route) {
                MyBookingsScreen(
                    bookings = bookingViewModel.bookings,
                    onStatusUpdate = { bookingId ->
                        bookingViewModel.updateBookingStatus(bookingId)
                    },
                    onBookingClick = { bookingId ->
                        navController.navigate(
                            Screen.BookingDetails.createRoute(bookingId)
                        )
                    }
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen(
                    userProfile = profileViewModel.userProfile.value,
                    onSaveProfile = { name, phoneNumber, city, language ->
                        profileViewModel.updateProfile(
                            name = name,
                            phoneNumber = phoneNumber,
                            city = city,
                            language = language
                        )
                    }
                )

            }
        }
    }
}