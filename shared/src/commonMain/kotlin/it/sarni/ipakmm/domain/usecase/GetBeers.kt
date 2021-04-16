package it.sarni.ipakmm.domain.usecase

import it.sarni.ipakmm.domain.entity.Beer
import it.sarni.ipakmm.domain.repository.BeerRepo


class GetBeers(private val beerRepo: BeerRepo) {
    suspend operator fun invoke() = GetBeersResponse(beerRepo.getBeers())
}

class GetBeersResponse(val listBeers: List<Beer>)