package ru.akurbanoff.home.data.models

data class Coffee(
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val image: String,
    val id: Int
)
