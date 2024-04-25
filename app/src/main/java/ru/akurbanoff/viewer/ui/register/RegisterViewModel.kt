package ru.akurbanoff.viewer.ui.register

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class RegisterViewModel @AssistedInject constructor(

): ViewModel() {
    // TODO: Implement the ViewModel

    @AssistedFactory
    interface Factory{
        fun create(): RegisterViewModel
    }
}