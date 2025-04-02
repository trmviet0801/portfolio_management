package com.example.portfoliomanagement.portfolio.data

import com.example.portfoliomanagement.domain.NetworkError
import com.example.portfoliomanagement.domain.Result
import com.example.portfoliomanagement.domain.StockDataSource
import com.example.portfoliomanagement.networking.safeCall
import com.example.portfoliomanagement.portfolio.domain.Stock
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteStockDataSource (
    private val httpClient: HttpClient
): StockDataSource {
    override suspend fun getStock(symbol: String): Result<Stock, NetworkError> {
        return safeCall<Stock> { httpClient.get("http://192.168.1.104:8081/stock/RSLS") }
    }
}