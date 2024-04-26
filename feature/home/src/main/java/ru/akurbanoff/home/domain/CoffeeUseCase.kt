package ru.akurbanoff.home.domain

import ru.akurbanoff.core.NetworkState
import ru.akurbanoff.home.data.api.CoffeeApi
import ru.akurbanoff.home.data.models.Coffee
import javax.inject.Inject

class CoffeeUseCase @Inject constructor(
    val coffeeApi: CoffeeApi
) {
    suspend fun getCoffees(): NetworkState {
        return runCatching {
            coffeeApi.getCoffees()
        }.mapCatching { response ->
            if(response.isSuccessful){
                NetworkState.Success(response.body() ?: emptyList())
            } else {
                NetworkState.ServerError(response.errorBody()?.string() ?: "Something went wrong")
            }
        }.getOrElse(NetworkState::Error)
    }
}