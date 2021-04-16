package it.sarni.ipakmm.data

import it.sarni.ipakmm.data.remote.BeerRemoteSource
import it.sarni.ipakmm.domain.entity.Beer
import it.sarni.ipakmm.domain.repository.BeerRepo

class BeerRepoImp(private val remoteSource: BeerRemoteSource): BeerRepo {
    override suspend fun getBeers(): List<Beer> = remoteSource.getBeers()

    override suspend fun getBeer(id: Int): Beer {
        TODO("Not yet implemented")
    }
}