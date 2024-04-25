package ru.akurbanoff.profile.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import dagger.Subcomponent
import ru.akurbanoff.profile.ui.profile.ProfileViewModel
import kotlin.properties.Delegates

@Subcomponent
interface ProfileComponent : ProfileDeps {
    override val profileViewModel: ProfileViewModel.Factory

    @Subcomponent.Builder
    interface Builder{
        fun create(): ProfileComponent
    }
}

interface ProfileDeps {
    val profileViewModel: ProfileViewModel.Factory
}

interface ProfileDepsProvider{
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: ProfileDeps

    companion object: ProfileDepsProvider by ProfileDepsStore
}

object ProfileDepsStore: ProfileDepsProvider{
    override var deps: ProfileDeps by Delegates.notNull()
}

internal class ProfileViewModelComponent: ViewModel() {
    val profileComponent = ProfileDepsStore.deps as ProfileComponent
}