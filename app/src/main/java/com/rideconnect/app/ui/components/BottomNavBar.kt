package com.rideconnect.app.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.rideconnect.app.navigation.Screen

@Composable
fun BottomNavBar(
    navController: NavController
) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(Screen.Home.route)
            },
            label = {
                Text("Home")
            },
            icon = {
                Text("🏠")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(Screen.MyBookings.route)
            },
            label = {
                Text("Bookings")
            },
            icon = {
                Text("📋")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(Screen.Profile.route)
            },
            label = {
                Text("Profile")
            },
            icon = {
                Text("👤")
            }
        )
    }
}