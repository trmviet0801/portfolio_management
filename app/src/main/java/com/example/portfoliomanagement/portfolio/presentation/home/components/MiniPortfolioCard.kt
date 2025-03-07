package com.example.portfoliomanagement.portfolio.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun MiniPortFolioCard(
    stockPriceUi: StockPriceUi
) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = containerColor
        ),
        modifier = Modifier
            .padding(8.dp)
            .border((0.4).dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .width(150.dp)
                .padding(8.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stockPriceUi.companyName,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                )
                Text(
                    text = stockPriceUi.symbol,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (stockPriceUi.change > 0) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "+${stockPriceUi.change} (+${stockPriceUi.percentChange})",
                            color = MaterialTheme.colorScheme.tertiary,
                            fontSize = 12.sp,
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.up),
                            contentDescription = stringResource(R.string.up),
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "${stockPriceUi.currentPrice}",
                            color = MaterialTheme.colorScheme.tertiary,
                            fontSize = 12.sp,
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.price_chart),
                            contentDescription = stringResource(R.string.chart),
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }
            } else {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${stockPriceUi.change} (${stockPriceUi.percentChange})",
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 12.sp,
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.down),
                            contentDescription = stringResource(R.string.up),
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "${stockPriceUi.currentPrice}",
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 12.sp,
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.price_chart),
                            contentDescription = stringResource(R.string.chart),
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun MiniPortfolioCardPreview() {
    PortfolioManagementTheme {
        MiniPortFolioCard(priceStocksPreview[1])
    }
}