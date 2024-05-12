package ru.akurbanoff.home.ui

import android.annotation.SuppressLint
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
import ru.akurbanoff.home.domain.interfaces.CoffeeUseCaseInterface

class HomeViewModel @AssistedInject constructor(
    private val useCase: CoffeeUseCaseInterface
) : ViewModel() {

    val state = MutableLiveData(HomeState())

    @SuppressLint("CheckResult")
    fun getCoffees(){
        useCase.getCoffees()
            .subscribe ({ response ->
                state.value = state.value?.copy(
                    coffees = response.body() ?: emptyList()
                )
            },{ error ->
                state.value = state.value?.copy(
                    errorMessage = error.localizedMessage ?: "Something went wrong"
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