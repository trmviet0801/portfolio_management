package com.example.portfoliomanagement.portfolio.presentation.profile

import android.provider.ContactsContract.Profile
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.portfoliomanagement.portfolio.presentation.profile.components.PortfolioList
import com.example.portfoliomanagement.portfolio.presentation.profile.components.PortfolioValue
import com.example.portfoliomanagement.portfolio.presentation.profile.components.PriceChart
import com.example.portfoliomanagement.portfolio.presentation.profile.components.ProfileTopBar
import com.example.portfoliomanagement.portfolio.presentation.utils.portfolioPreview
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.portfolio.presentation.utils.pricesPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    navController: NavController?
) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
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
            .padding(top = 26.dp, bottom = 36.dp),
        // verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ProfileTopBar()
            PortfolioValue(portfolioPreview)
            PortfolioList(priceStocksPreview)
            PriceChart(pricesPreview)
        }
        AnimatedVisibility(
            visible = isShowMenu.value
        ) {
            BottomNavigation(navController)
        }
    }
}

@Composable
@PreviewLightDark
private fun ProfilePreview() {
    PortfolioManagementTheme {
        ProfileScreen(null)
    }
}