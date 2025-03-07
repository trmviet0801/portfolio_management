package com.example.portfoliomanagement.portfolio.presentation.bottomNav

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.portfolio.presentation.bottomNav.component.BottomNavigationItem
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun BottomNavigation(navController: NavController?) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(
            containerColor = containerColor
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            BottomNavigationItem(
                stringResource(R.string.home),
                R.drawable.home,
                navController
            )
            BottomNavigationItem(
                stringResource(R.string.trending),
                R.drawable.trending,
                navController
            )
            BottomNavigationItem(
                stringResource(R.string.market),
                R.drawable.market,
                navController
            )
            BottomNavigationItem(
                stringResource(R.string.profile),
                R.drawable.profile,
                navController
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun BottomNavigationPreview() {
    PortfolioManagementTheme {
        BottomNavigation(null)
    }
}