package ru.akurbanoff.home.di.modules

import dagger.Module
import dagger.Provides
import ru.akurbanoff.home.data.api.CoffeeApi
import ru.akurbanoff.home.domain.CoffeeUseCase
import javax.inject.Singleton

@Module
class UseCaseProvider {
    @[Provides]
    fun provideCoffeeUseCase(
        api: CoffeeApi
    ): CoffeeUseCase = CoffeeUseCase(api)
}