package com.example.portfoliomanagement.portfolio.presentation.trending

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.portfoliomanagement.portfolio.presentation.bottomNav.BottomNavigation
import com.example.portfoliomanagement.portfolio.presentation.trending.components.StockHistory
import com.example.portfoliomanagement.portfolio.presentation.trending.components.TopBar
import com.example.portfoliomanagement.portfolio.presentation.trending.components.TrendingList
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun TrendingScreen(
    navController: NavController?
) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White;
    val isShowMenu = remember { mutableStateOf(true) }
    val scrollState = rememberScrollState();

    if (scrollState.isScrollInProgress)
        isShowMenu.value = scrollState.lastScrolledBackward
    if (!scrollState.canScrollBackward)
        isShowMenu.value = true
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(containerColor)
            .padding(16.dp)
            .padding(top = 26.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            TopBar()
            StockHistory(priceStocksPreview)
            TrendingList(priceStocksPreview)
        }
        AnimatedVisibility(visible = isShowMenu.value) { BottomNavigation(navController) }
    }
}

@PreviewLightDark
@Composable
private fun TrendingScreenPreview() {
    PortfolioManagementTheme {
        TrendingScreen(null)
    }
}