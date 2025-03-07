package com.example.portfoliomanagement.portfolio.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.portfoliomanagement.portfolio.presentation.bottomNav.BottomNavigation
import com.example.portfoliomanagement.portfolio.presentation.home.components.MiniPortfolio
import com.example.portfoliomanagement.portfolio.presentation.home.components.SearchBox
import com.example.portfoliomanagement.portfolio.presentation.home.components.TopBar
import com.example.portfoliomanagement.portfolio.presentation.home.components.TopMenu
import com.example.portfoliomanagement.portfolio.presentation.home.components.WatchList
import com.example.portfoliomanagement.portfolio.presentation.home.components.previewUser
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun HomeScreen(
    navController: NavController?
) {
    val keyword = remember { mutableStateOf("") }
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    val localFocus = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(containerColor)
            .padding(16.dp)
            .padding(top = 25.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocus.clearFocus()
                }
                )
            },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TopBar(previewUser)
            SearchBox(keyword)
            TopMenu()
            MiniPortfolio(priceStocksPreview)
            WatchList(priceStocksPreview)
        }
        BottomNavigation(navController)
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    PortfolioManagementTheme {
        HomeScreen(null)
    }
}