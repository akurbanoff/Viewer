package ru.akurbanoff.home.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import dagger.Subcomponent
import ru.akurbanoff.home.ui.HomeViewModel
import kotlin.properties.Delegates.notNull

@Subcomponent
interface HomeComponent: HomeDeps {
    override val homeViewModel: HomeViewModel.Factory

    @Subcomponent.Builder
    interface Builder{
        fun create(): HomeComponent
    }
}

interface HomeDeps {
    val homeViewModel: HomeViewModel.Factory
}

interface HomeDepsProvider{
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: HomeDeps

    companion object: HomeDepsProvider by HomeDepsStore
}

object HomeDepsStore: HomeDepsProvider{
    override var deps: HomeDeps by notNull()
}

internal class HomeViewModelComponent: ViewModel() {
    val homeComponent = HomeDepsStore.deps as HomeComponent
}