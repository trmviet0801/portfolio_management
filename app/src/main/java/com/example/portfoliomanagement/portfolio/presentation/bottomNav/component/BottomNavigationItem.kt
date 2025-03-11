package com.example.portfoliomanagement.portfolio.presentation.bottomNav.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun BottomNavigationItem(
    name: String,
    @DrawableRes icon: Int,
    navController: NavController?
) {
    val currentRoute = navController?.currentBackStackEntry?.destination?.route
    var color = MaterialTheme.colorScheme.secondary
    if (currentRoute.equals(name)) {
        color = MaterialTheme.colorScheme.primary
    }
    Column (
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = {
                navController?.navigate(name)
            }),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = name,
            tint = color,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            color = color,
            fontSize = 12.sp
        )
    }
}

@PreviewLightDark
@Composable
private fun BottomNavigationItemPreview() {
    PortfolioManagementTheme {
        BottomNavigationItem(
            "Home",
            R.drawable.home, null
        )
    }
}