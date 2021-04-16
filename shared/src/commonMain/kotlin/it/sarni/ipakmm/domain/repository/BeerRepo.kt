package it.sarni.ipakmm.domain.repository

import it.sarni.ipakmm.domain.entity.Beer

interface BeerRepo {
    suspend fun getBeers() : List<Beer>

    suspend fun getBeer(id: Int) : Beer
}