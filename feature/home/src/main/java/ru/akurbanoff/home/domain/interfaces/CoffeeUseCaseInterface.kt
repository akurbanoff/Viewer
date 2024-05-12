package ru.akurbanoff.home.domain.interfaces

import io.reactivex.Single
import retrofit2.Response
import ru.akurbanoff.home.data.models.Coffee

interface CoffeeUseCaseInterface {
    fun getCoffees(): Single<Response<List<Coffee>>>
}