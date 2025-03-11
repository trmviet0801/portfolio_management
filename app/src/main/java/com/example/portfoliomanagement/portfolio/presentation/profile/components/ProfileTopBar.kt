package com.example.portfoliomanagement.portfolio.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun ProfileTopBar() {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.my_portfolio),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.add),
            contentDescription = stringResource(R.string.add),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@PreviewLightDark
@Composable
private fun ProfileTopBarPreview() {
    PortfolioManagementTheme {
        ProfileTopBar()
    }
}