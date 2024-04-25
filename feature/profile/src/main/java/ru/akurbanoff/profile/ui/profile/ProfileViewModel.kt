package ru.akurbanoff.profile.ui.profile

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ProfileViewModel @AssistedInject constructor(

): ViewModel() {
    // TODO: Implement the ViewModel

    @AssistedFactory
    interface Factory{
        fun create(): ProfileViewModel
    }
}