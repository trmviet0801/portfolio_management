package com.example.portfoliomanagement.portfolio.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.portfolio.presentation.model.Portfolio
import com.example.portfoliomanagement.portfolio.presentation.model.format
import com.example.portfoliomanagement.portfolio.presentation.utils.portfolioPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun PortfolioValue(portfolio: Portfolio) {
    val contentColor: Color =
        if (portfolio.change > 0) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error
    val icon: Int = if (portfolio.change > 0) R.drawable.up else R.drawable.down
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border((0.4).dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = stringResource(R.string.portfolio_value),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp
            )
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = portfolio.value.format(),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(R.string.vnd),
                    color = MaterialTheme.colorScheme.primary,
                    //fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.change),
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 14.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(icon),
                            contentDescription = stringResource(R.string.icon),
                            tint = contentColor
                        )
                        Text(
                            text = portfolio.change.format(),
                            color = contentColor,
                            fontSize = 18.sp
                        )
                    }
                }
                Column {
                    Text(
                        text = stringResource(R.string.percent_change),
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "${portfolio.percentageChange.format()}%",
                        color = contentColor,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PortfolioValuePreview() {
    PortfolioManagementTheme {
        PortfolioValue(portfolioPreview)
    }
}