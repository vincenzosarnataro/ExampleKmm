package it.sarni.ipakmm.data.remote

import io.ktor.client.*
import io.ktor.client.request.*
import it.sarni.ipakmm.domain.entity.Beer

class BeerRemoteSourceImp(private val client: HttpClient) : BeerRemoteSource {
    companion object {
        private const val ROOT_URL = "https://api.punkapi.com/v2"
    }

    override suspend fun getBeers(): List<Beer> = client.get("$ROOT_URL/beers")

}