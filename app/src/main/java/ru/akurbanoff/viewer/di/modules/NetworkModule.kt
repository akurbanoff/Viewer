package ru.akurbanoff.viewer.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}