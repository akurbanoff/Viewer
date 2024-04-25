package ru.akurbanoff.favorites.ui

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class FavoritesViewModel @AssistedInject constructor(

) : ViewModel() {
    // TODO: Implement the ViewModel

    @AssistedFactory
    interface Factory{
        fun create() : FavoritesViewModel
    }
}