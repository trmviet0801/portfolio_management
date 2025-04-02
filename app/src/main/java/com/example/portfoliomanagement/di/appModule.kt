package com.example.portfoliomanagement.di

import com.example.portfoliomanagement.networking.HttpClientFactory
import com.example.portfoliomanagement.portfolio.data.RemoteStockDataSource
import com.example.portfoliomanagement.domain.StockDataSource
import com.example.portfoliomanagement.portfolio.presentation.profile.ProfileViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    viewModel { ProfileViewModel(get()) }
    single { HttpClientFactory.create(CIO.create()) }
    single { RemoteStockDataSource(get()) }.bind<StockDataSource>()
}