package ru.akurbanoff.home.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Coffee(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("ingredients") val ingredients: List<String>,
    @SerializedName("image") val image: String,
    @SerializedName("id") val id: Int,
    //var price: Int
)
