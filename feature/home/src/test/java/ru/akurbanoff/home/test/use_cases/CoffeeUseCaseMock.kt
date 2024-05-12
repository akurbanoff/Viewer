package ru.akurbanoff.home.test.use_cases

import io.reactivex.Single
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import ru.akurbanoff.home.data.models.Coffee
import ru.akurbanoff.home.domain.interfaces.CoffeeUseCaseInterface

class CoffeeUseCaseMock : CoffeeUseCaseInterface{
    override fun getCoffees(): Single<Response<List<Coffee>>> {
        val mockData = listOf(
            Coffee(
                id = 0,
                title = "Test",
                image = "image",
                description = "test",
                ingredients = emptyList()
            )
        )
        return Single.just(Response.success(mockData))
    }
}