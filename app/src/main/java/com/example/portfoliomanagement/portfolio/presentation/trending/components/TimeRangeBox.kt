package com.example.portfoliomanagement.portfolio.presentation.trending.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.portfolio.presentation.utils.TIME_RANGE
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun TimeRangeBox(isShowing: MutableState<Boolean>?) {
    val selectedTimeRange = remember { mutableIntStateOf(TIME_RANGE[0]) }
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Card(
        modifier = Modifier
            .clickable(
                onClick = {
                    isShowing?.value = !isShowing?.value!!
                }
            )
            .border((0.4).dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Column(
            modifier = Modifier.width(90.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${selectedTimeRange.intValue} ${getTimeRangeUnit(selectedTimeRange.intValue)}",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.arrow_down),
                    contentDescription = stringResource(R.string.arrow_down),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(8.dp)
                )
            }
            AnimatedVisibility(
                visible = isShowing?.value ?: false
            ) {
                Column {
                    TIME_RANGE.filter { it != selectedTimeRange.intValue }.forEach {
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .clickable(onClick = {
                                    selectedTimeRange.intValue = it
                                    isShowing?.value = false
                                }),
                            colors = CardDefaults.cardColors(
                                containerColor = containerColor
                            )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(
                                        text = "$it ${getTimeRangeUnit(it)}",
                                        color = MaterialTheme.colorScheme.primary,
                                        fontSize = 12.sp,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun getTimeRangeUnit(timeRange: Int): String {
    return if (timeRange < 8) stringResource(R.string.day) else stringResource(R.string.hour)
}

@Composable
@PreviewLightDark
private fun TimeRangeBoxPreview() {
    PortfolioManagementTheme {
        TimeRangeBox(null)
    }
}