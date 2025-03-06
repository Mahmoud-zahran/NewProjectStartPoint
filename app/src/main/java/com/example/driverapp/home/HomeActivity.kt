package com.example.driverapp.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation.compose.rememberNavController
import com.example.driverapp.home.ui.DriverAppScreen
import com.example.driverapp.home.viewmodel.DriverViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val driverViewModel: DriverViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            DriverAppScreen(
                viewModel = driverViewModel,
                windowSize = calculateWindowSizeClass(activity = this),
                navController = navController
            )
        }

//        lifecycleScope.launch {
//            driverViewModel.getCharacters()
//        }

    }
}


