package ru.akurbanoff.menu.ui.coffies

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class CoffiesViewModel @AssistedInject constructor(

): ViewModel() {
    // TODO: Implement the ViewModel
    @AssistedFactory
    interface Factory{
        fun create(): CoffiesViewModel
    }
}