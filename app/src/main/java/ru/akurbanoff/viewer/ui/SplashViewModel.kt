package ru.akurbanoff.viewer.ui

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SplashViewModel @AssistedInject constructor(

): ViewModel() {
    // TODO: Implement the ViewModel

    @AssistedFactory
    interface Factory{
        fun create(): SplashViewModel
    }
}