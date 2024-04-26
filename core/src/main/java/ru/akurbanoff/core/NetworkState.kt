package ru.akurbanoff.core

sealed interface NetworkState {
    data class Success<T>(val data: T?): NetworkState

    data class Error(val error: Throwable): NetworkState

    data class ServerError(val descriptionError: String): NetworkState
}