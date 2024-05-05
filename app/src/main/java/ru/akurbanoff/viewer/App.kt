package ru.akurbanoff.viewer

import android.app.Application
import ru.akurbanoff.cart.di.CartComponent
import ru.akurbanoff.cart.di.CartDepsStore
import ru.akurbanoff.favorites.di.FavoriteComponent
import ru.akurbanoff.favorites.di.FavoriteDepsStore
import ru.akurbanoff.home.di.HomeComponent
import ru.akurbanoff.home.di.HomeDepsStore
import ru.akurbanoff.menu.di.MenuComponent
import ru.akurbanoff.menu.di.MenuDepsStore
import ru.akurbanoff.profile.di.ProfileComponent
import ru.akurbanoff.profile.di.ProfileDepsStore
import ru.akurbanoff.viewer.di.AppComponent
import ru.akurbanoff.viewer.di.DaggerAppComponent

class App: Application() {
    private lateinit var appComponent: AppComponent
    lateinit var homeComponent: HomeComponent
    private lateinit var favoritesComponent: FavoriteComponent
    private lateinit var cartComponent: CartComponent
    private lateinit var menuComponent: MenuComponent
    private lateinit var profileComponent: ProfileComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)

        homeComponent = appComponent.provideHomeComponent.create()
        HomeDepsStore.deps = homeComponent

        favoritesComponent = appComponent.provideFavoriteComponent.create()
        FavoriteDepsStore.deps = favoritesComponent

        cartComponent = appComponent.provideCartComponent.create()
        CartDepsStore.deps = cartComponent

        menuComponent = appComponent.provideMenuComponent.create()
        MenuDepsStore.deps = menuComponent

        profileComponent = appComponent.provideProfileComponent.create()
        ProfileDepsStore.deps = profileComponent
    }
}

