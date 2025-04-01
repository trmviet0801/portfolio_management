package com.example.portfoliomanagement.portfolio.di

import com.example.portfoliomanagement.portfolio.presentation.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ProfileViewModel() }
}