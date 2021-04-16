package it.sarni.ipakmm.data.remote

import it.sarni.ipakmm.domain.entity.Beer

interface BeerRemoteSource {
    suspend fun getBeers():List<Beer>
}