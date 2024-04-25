package ru.akurbanoff.viewer.ui.sign_in

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SignInViewModel @AssistedInject constructor(

): ViewModel() {
    // TODO: Implement the ViewModel
    @AssistedFactory
    interface Factory{
        fun create(): SignInViewModel
    }
}