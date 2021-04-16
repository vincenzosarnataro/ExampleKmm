package it.sarni.ipakmm.di

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import it.sarni.ipakmm.data.BeerRepoImp
import it.sarni.ipakmm.data.remote.BeerRemoteSource
import it.sarni.ipakmm.data.remote.BeerRemoteSourceImp
import it.sarni.ipakmm.domain.entity.Beer
import it.sarni.ipakmm.domain.repository.BeerRepo
import it.sarni.ipakmm.domain.usecase.GetBeers
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.reflect.typeOf



fun initKoin(appModule: Module): KoinApplication {
    return startKoin {

        modules(
            appModule,
            platformModule,
            coreModule
        )
    }
}

@OptIn(ExperimentalStdlibApi::class)
private val coreModule = module {

    single {
        HttpClient {
            install(Logging)
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    isLenient = false
                    ignoreUnknownKeys = true
                    allowSpecialFloatingPointValues = true
                    useArrayPolymorphism = false
                }).apply {
                    typeOf<List<Beer>>()
                }
            }
        }
    }
    // Source
    single<BeerRemoteSource> { BeerRemoteSourceImp(get()) }

    //Repo
    single<BeerRepo> { BeerRepoImp(get()) }

    //Use Case
    single { GetBeers(get()) }


}

expect val platformModule: Module
