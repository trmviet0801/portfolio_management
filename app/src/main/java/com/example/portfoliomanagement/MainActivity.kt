package com.example.portfoliomanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfoliomanagement.portfolio.presentation.home.HomeScreen
import com.example.portfoliomanagement.portfolio.presentation.profile.ProfileScreen
import com.example.portfoliomanagement.portfolio.presentation.profile.components.ProfileTopBar
import com.example.portfoliomanagement.portfolio.presentation.trending.TrendingScreen
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioManagementTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ) {
                    composable("Home") {
                        HomeScreen(navController)
                    }
                    composable("Trending") {
                        TrendingScreen(navController)
                    }
                    composable("Profile") {
                        ProfileScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioManagementTheme {
        Greeting("Android")
    }
}