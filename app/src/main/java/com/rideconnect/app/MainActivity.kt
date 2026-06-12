package com.rideconnect.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rideconnect.app.ui.splash.SplashScreen
import com.rideconnect.app.ui.theme.RideConnectTheme
import com.rideconnect.app.navigation.NavGraph
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RideConnectTheme {
                NavGraph()
            }
        }
    }
}