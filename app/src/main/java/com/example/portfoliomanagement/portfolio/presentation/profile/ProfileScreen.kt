package com.example.portfoliomanagement.portfolio.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.portfoliomanagement.portfolio.presentation.bottomNav.BottomNavigation
import com.example.portfoliomanagement.portfolio.presentation.profile.components.PortfolioList
import com.example.portfoliomanagement.portfolio.presentation.profile.components.PortfolioValue
import com.example.portfoliomanagement.portfolio.presentation.profile.components.ProfileTopBar
import com.example.portfoliomanagement.portfolio.presentation.utils.portfolioPreview
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun ProfileScreen(
    navController: NavController?
) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(containerColor)
            .padding(16.dp)
            .padding(top = 26.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ProfileTopBar()
            PortfolioValue(portfolioPreview)
            PortfolioList(priceStocksPreview)
        }
        BottomNavigation(navController)
    }
}

@Composable
@PreviewLightDark
private fun ProfilePreview() {
    PortfolioManagementTheme {
        ProfileScreen(null)
    }
}