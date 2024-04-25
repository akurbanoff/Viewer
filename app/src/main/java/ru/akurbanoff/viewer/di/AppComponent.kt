package ru.akurbanoff.viewer.di

import android.content.Context
import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import dagger.Component
import ru.akurbanoff.cart.di.CartComponent
import ru.akurbanoff.favorites.di.FavoriteComponent
import ru.akurbanoff.favorites.ui.FavoritesViewModel
import ru.akurbanoff.home.di.HomeComponent
import ru.akurbanoff.menu.di.MenuComponent
import ru.akurbanoff.profile.di.ProfileComponent
import ru.akurbanoff.viewer.di.modules.NetworkModule
import ru.akurbanoff.viewer.ui.SplashViewModel
import ru.akurbanoff.viewer.ui.register.RegisterViewModel
import ru.akurbanoff.viewer.ui.sign_in.SignInViewModel
import javax.inject.Singleton
import kotlin.properties.Delegates

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent: AppDeps {
    override val splashViewModel: SplashViewModel.Factory
    override val signInViewModel: SignInViewModel.Factory
    override val registerViewModel: RegisterViewModel.Factory

    val provideHomeComponent: HomeComponent.Builder
    val provideFavoriteComponent: FavoriteComponent.Builder
    val provideCartComponent: CartComponent.Builder
    val provideMenuComponent: MenuComponent.Builder
    val provideProfileComponent: ProfileComponent.Builder

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}

interface AppDeps {
    val splashViewModel: SplashViewModel.Factory
    val signInViewModel: SignInViewModel.Factory
    val registerViewModel: RegisterViewModel.Factory
}

interface AppDepsProvider{
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: AppDeps

    companion object: AppDepsProvider by AppDepsStore
}

object AppDepsStore: AppDepsProvider{
    override var deps: AppDeps by Delegates.notNull()
}

internal class FavoriteViewModelComponent: ViewModel() {
    val appComponent = AppDepsStore.deps as AppComponent
}