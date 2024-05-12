package ru.akurbanoff.home.di.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.akurbanoff.home.data.api.CoffeeApi
import javax.inject.Singleton

@Module
internal class ApiProvider {
    @[Provides]
    fun provideCoffeeApi(
        retrofit: Retrofit
    ): CoffeeApi = retrofit.create(CoffeeApi::class.java)
}