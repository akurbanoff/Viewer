package ru.akurbanoff.cart.ui.cart

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class CartViewModel @AssistedInject constructor(

): ViewModel() {
    // TODO: Implement the ViewModel

    @AssistedFactory
    interface Factory{
        fun create(): CartViewModel
    }
}