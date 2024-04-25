package ru.akurbanoff.viewer.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.akurbanoff.cart.di.CartComponent
import ru.akurbanoff.favorites.di.FavoriteComponent
import ru.akurbanoff.home.di.HomeComponent
import ru.akurbanoff.menu.di.MenuComponent
import ru.akurbanoff.profile.di.ProfileComponent
import javax.inject.Singleton

@Module(subcomponents = [
    HomeComponent::class,
    FavoriteComponent::class,
    CartComponent::class,
    MenuComponent::class,
    ProfileComponent::class
])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient{
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/coffee/hot")
            .client(okHttpClient)
            .build()
    }
}