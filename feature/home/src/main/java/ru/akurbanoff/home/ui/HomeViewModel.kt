package ru.akurbanoff.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.Single
import kotlinx.coroutines.launch
import ru.akurbanoff.core.NetworkState
import ru.akurbanoff.home.data.models.Coffee
import ru.akurbanoff.home.domain.CoffeeUseCase

class HomeViewModel @AssistedInject constructor(
    private val useCase: CoffeeUseCase
) : ViewModel() {

    val state = MutableLiveData(HomeState())

    fun getCoffees(){
        useCase.getCoffees()
            .subscribe ({
                state.value = state.value?.copy(
                    coffees = it.body() ?: listOf(Coffee(title = "Artem", description = "", image = "", ingredients = listOf(""), id = 1))
                )
            },{
                state.value = state.value?.copy(
                    errorMessage = it.localizedMessage ?: "Something went wrong"
                )
            })
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