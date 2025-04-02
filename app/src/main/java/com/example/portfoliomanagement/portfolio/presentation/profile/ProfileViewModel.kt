package com.example.portfoliomanagement.portfolio.presentation.profile

import android.util.Log
import androidx.compose.ui.geometry.Size
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portfoliomanagement.domain.StockDataSource
import com.example.portfoliomanagement.domain.onError
import com.example.portfoliomanagement.domain.onSuccess
import com.example.portfoliomanagement.portfolio.data.RemoteStockDataSource
import com.example.portfoliomanagement.portfolio.presentation.profile.model.Price
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val stockDataSource: StockDataSource
): ViewModel() {
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

    fun getStock() {
        viewModelScope.launch {
            stockDataSource.getStock("nvda").onSuccess { stock ->
                Log.d("response stock", stock.name)
            }.onError { error -> Log.d("response stock", error.name) }
        }
    }
}