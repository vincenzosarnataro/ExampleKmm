package it.sarni.ipakmm.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Beer(
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description : String,
    @SerialName("abv")
    val abv : Float?,
    @SerialName("ibu")
    val ibu : Float?,
    @SerialName("first_brewed")
    val firstBrewed : String,
    @SerialName("brewers_tips")
    val brewersTips : String,

)