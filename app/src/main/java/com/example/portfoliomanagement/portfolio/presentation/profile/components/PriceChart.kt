package com.example.portfoliomanagement.portfolio.presentation.profile.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.portfoliomanagement.portfolio.presentation.profile.ProfileViewModel
import com.example.portfoliomanagement.portfolio.presentation.profile.model.Price
import com.example.portfoliomanagement.portfolio.presentation.utils.pricesPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme
import org.koin.androidx.compose.koinViewModel
import java.time.Duration
import kotlin.math.roundToInt

@Composable
fun PriceChart(prices: List<Price>) {
    val viewModel: ProfileViewModel = koinViewModel()
    val primaryColor: Color = MaterialTheme.colorScheme.tertiary
    val space = (Duration.between(
        prices[0].timestamp, prices[prices.size - 1].timestamp
    ).toMinutes().toInt()) / (prices.size - 1)
    val maxPriceValue: Price? = getMaxPrice(prices)
    val minPriceValue: Price? = getMinPrice(prices)
    val totalLength =
        Duration.between(prices[0].timestamp, prices[prices.size - 1].timestamp).toMinutes().toInt()

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(16.dp)
    ) {
        val positions: List<List<Float>> = viewModel.parsePricesToOffset(pricesPreview, size)

        //prices line
        val pathFill = Path()
        val pathStroke = Path()
        pathFill.moveTo(0f, size.height)
        for (i in 0..positions.size - 1) {
            pathFill.lineTo(positions[i][0], positions[i][1])
            pathStroke.lineTo(positions[i][0], positions[i][1])
        }
        pathFill.lineTo(positions[positions.size -1][0], size.height)
        drawPath(pathFill, Brush.verticalGradient(listOf(primaryColor, Color.White)), 1f)
        drawPath(pathStroke, primaryColor, 1f, Stroke(width = 6f))

        //y
        drawLine(
            color = primaryColor,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 10f,
            cap = StrokeCap.Round
        )
        //x
        drawLine(
            color = primaryColor,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 10f,
            cap = StrokeCap.Round
        )

        //net
        for (i in 0..9) {
            val y: Float = (size.height / 10 * i).roundToInt().toFloat();
            val x: Float = (size.width / 10 * i).roundToInt().toFloat();
            drawLine(
                color = primaryColor,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f)),
                cap = StrokeCap.Round,
            )
            drawLine(
                color = primaryColor,
                start = Offset(x, size.height),
                end = Offset(x, 0f),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f)),
                cap = StrokeCap.Round
            )
        }

        //dots
        for (i in 0..positions.size - 1)
            drawCircle(Color.Red, radius = 7f, center = Offset(positions[i][0], positions[i][1]))
    }
}

private fun getMaxPrice(prices: List<Price>): Price? {
    if (prices.isEmpty()) return null
    var max: Price = prices[0]
    prices.forEach { price ->
        if (price.value > max.value) max = price
    }
    return max
}

private fun getMinPrice(prices: List<Price>): Price? {
    if (prices.isEmpty()) return null
    var min: Price = prices[0]
    prices.forEach { price ->
        if (price.value < min.value) min = price
    }
    return min
}

@PreviewLightDark
@Composable
private fun PriceChartPreview() {
    PortfolioManagementTheme {
        PriceChart(pricesPreview)
    }
}