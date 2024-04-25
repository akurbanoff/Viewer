package ru.akurbanoff.cart.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import dagger.Subcomponent
import ru.akurbanoff.cart.ui.cart.CartViewModel
import kotlin.properties.Delegates

@Subcomponent
interface CartComponent: CartDeps {
    override val cartViewModel: CartViewModel.Factory

    @Subcomponent.Builder
    interface Builder{
        fun create(): CartComponent
    }
}

interface CartDeps {
    val cartViewModel: CartViewModel.Factory
}

interface CartDepsProvider{
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: CartDeps

    companion object: CartDepsProvider by CartDepsStore
}

object CartDepsStore: CartDepsProvider{
    override var deps: CartDeps by Delegates.notNull()
}

internal class CartViewModelComponent: ViewModel() {
    val cartComponent = CartDepsStore.deps as CartComponent
}