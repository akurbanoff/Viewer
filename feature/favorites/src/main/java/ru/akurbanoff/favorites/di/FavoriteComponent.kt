package ru.akurbanoff.favorites.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import dagger.Subcomponent
import ru.akurbanoff.favorites.ui.FavoritesViewModel
import kotlin.properties.Delegates

@Subcomponent
interface FavoriteComponent : FavoriteDeps {
    override val favoriteViewModel: FavoritesViewModel.Factory

    @Subcomponent.Builder
    interface Builder{
        fun create(): FavoriteComponent
    }
}

interface FavoriteDeps {
    val favoriteViewModel: FavoritesViewModel.Factory
}

interface FavoriteDepsProvider{
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: FavoriteDeps

    companion object: FavoriteDepsProvider by FavoriteDepsStore
}

object FavoriteDepsStore: FavoriteDepsProvider{
    override var deps: FavoriteDeps by Delegates.notNull()
}

internal class FavoriteViewModelComponent: ViewModel() {
    val favoriteComponent = FavoriteDepsStore.deps as FavoriteComponent
}