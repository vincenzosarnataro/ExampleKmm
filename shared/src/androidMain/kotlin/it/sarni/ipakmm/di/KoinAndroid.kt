package it.sarni.ipakmm.di

import it.sarni.ipakmm.presentation.features.beer.BeerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual val platformModule = module {

viewModel { BeerViewModel(get()) }

}


