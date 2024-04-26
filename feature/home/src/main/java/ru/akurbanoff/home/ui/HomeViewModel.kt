package ru.akurbanoff.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.Single
import ru.akurbanoff.core.NetworkState
import ru.akurbanoff.home.data.models.Coffee
import ru.akurbanoff.home.domain.CoffeeUseCase

class HomeViewModel @AssistedInject constructor(
    private val useCase: CoffeeUseCase
) : ViewModel() {

    val state = MutableLiveData(HomeState())

    fun getCoffees(page: Int, limit: Int = 5): Single<List<Coffee>>{
        return Single.create { emitter ->
            when(val result = useCase.getCoffees()){
                is NetworkState.Success<*> -> {
                    val coffeeList = (result.data as List<Coffee>).subList(
                        fromIndex = 0,
                        toIndex = page * limit
                    )
                    emitter.onSuccess(result.data as? List<Coffee> ?: emptyList())
                }
                is NetworkState.ServerError -> {
                    emitter.onError(Throwable(result.descriptionError))
                }
                is NetworkState.Error -> {
                    emitter.onError(result.error)
                }
            }
        }
    }

    data class HomeState(
        val coffees: List<Coffee> = emptyList(),
        val errorMessage: String = ""
    )

    @AssistedFactory
    interface Factory {
        fun create(): HomeViewModel
    }
}