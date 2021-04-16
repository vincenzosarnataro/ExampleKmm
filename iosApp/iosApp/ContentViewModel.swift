//
//  ContentViewModel.swift
//  iosApp
//
//  Created by Lavoro Spindox on 16/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared
class ContentViewViewModel: ObservableObject {
    @Published var beers: [Beer]  = []
    
    private let viewModel:BeerViewModel
    init() {
        viewModel =   koin.get(objCClass: BeerViewModel.self, parameter: "ViewController") as!BeerViewModel
    }
    func fetchBeer() {
        viewModel.loadBeersState.watch { uiState in
            self.beers = uiState?.data?.listBeers ?? []
            
        }
    }
}
