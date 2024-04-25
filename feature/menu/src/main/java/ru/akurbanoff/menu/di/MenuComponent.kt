package ru.akurbanoff.menu.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import dagger.Subcomponent
import ru.akurbanoff.menu.ui.coffies.CoffiesViewModel
import kotlin.properties.Delegates

@Subcomponent
interface MenuComponent: MenuDeps {
    override val coffiesViewModel: CoffiesViewModel.Factory

    @Subcomponent.Builder
    interface Builder{
        fun create(): MenuComponent
    }
}

interface MenuDeps {
    val coffiesViewModel: CoffiesViewModel.Factory
}

interface MenuDepsProvider{
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: MenuDeps

    companion object: MenuDepsProvider by MenuDepsStore
}

object MenuDepsStore: MenuDepsProvider{
    override var deps: MenuDeps by Delegates.notNull()
}

internal class MenuViewModelComponent: ViewModel() {
    val menuComponent = MenuDepsStore.deps as MenuComponent
}