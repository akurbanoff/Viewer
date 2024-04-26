package ru.akurbanoff.home.ui

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.akurbanoff.home.domain.CoffeeUseCase

class HomeViewModel @AssistedInject constructor(
    private val useCase: CoffeeUseCase
) : ViewModel() {


    @AssistedFactory
    interface Factory {
        fun create(): HomeViewModel
    }
}