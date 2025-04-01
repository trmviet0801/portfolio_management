package com.example.portfoliomanagement.portfolio.presentation.profile

import androidx.compose.ui.geometry.Size
import androidx.lifecycle.ViewModel
import com.example.portfoliomanagement.portfolio.presentation.profile.model.Price

class ProfileViewModel: ViewModel() {
    private fun  maxPrice(prices: List<Price>): Price? {
        if (prices.isEmpty())
            return null;
        if (prices.size == 1)
            return prices[0]
        var max: Price = prices[0]
        prices.forEach { price ->
            if (price.value > max.value)
                max = price
        }
        return max
    }

    private fun minPrice(prices: List<Price>): Price? {
        if (prices.isEmpty())
            return null;
        if (prices.size == 1)
            return prices[0]
        var min: Price = prices[0]
        prices.forEach { price ->
            if (price.value < min.value)
                min = price
        }
        return min
    }

    fun parsePricesToOffset(prices: List<Price>, size: Size): List<List<Float>> {
        val positions: MutableList<MutableList<Float>> = mutableListOf()
        val maxPrice = maxPrice(prices)
        val minPrice = minPrice(prices)

        prices.forEachIndexed { index, price ->
            val offset: List<Float> = emptyList()
            val x: Float = size.width / (prices.size - 1) * (index)
            val y: Float = (size.height * 0.95f) - ((price.value - minPrice!!.value) / (maxPrice!!.value - minPrice!!.value) * (size.height * 0.95f))
                .toFloat()
            positions.add(index, mutableListOf(x, y))
        }
        return positions
    }
}