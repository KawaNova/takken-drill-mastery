package com.kawanova.takkendrill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.google.android.gms.ads.MobileAds
import com.kawanova.takkendrill.ui.TakkenViewModel
import com.kawanova.takkendrill.ui.navigation.NavGraph
import com.kawanova.takkendrill.ui.theme.TakkenDrillTheme

class MainActivity : ComponentActivity() {

    private val viewModel: TakkenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize Google Mobile Ads SDK in background
        MobileAds.initialize(this) {}

        setContent {
            TakkenDrillTheme {
                NavGraph(viewModel = viewModel)
            }
        }
    }
}
