package ru.akurbanoff.home.ui

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class HomeViewModel @AssistedInject constructor(

) : ViewModel() {
    // TODO: Implement the ViewModel

    @AssistedFactory
    interface Factory {
        fun create(): HomeViewModel
    }
}