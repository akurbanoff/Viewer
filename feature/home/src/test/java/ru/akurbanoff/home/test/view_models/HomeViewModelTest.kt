package ru.akurbanoff.home.test.view_models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.argumentCaptor
import io.reactivex.Single
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import ru.akurbanoff.home.data.models.Coffee
import ru.akurbanoff.home.test.use_cases.CoffeeUseCaseMock
import ru.akurbanoff.home.ui.HomeViewModel

class HomeViewModelTest{
    private lateinit var viewModel: HomeViewModel
    private lateinit var useCase: CoffeeUseCaseMock

    @Mock
    private lateinit var observer: Observer<HomeViewModel.HomeState>

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        useCase = CoffeeUseCaseMock()
        viewModel = HomeViewModel(useCase)
        viewModel.state.observeForever(observer)
    }

    @Test
    fun `state is empty`(){
        viewModel.getCoffees()

        val capturedStates = argumentCaptor<HomeViewModel.HomeState>()
        verify(observer, times(2)).onChanged(capturedStates.capture())

        assertEquals(HomeViewModel.HomeState(), capturedStates.firstValue) // Проверка начального пустого состояния
    }

    @Test
    fun `coffee list is successfully loads`(){
        val correctState = HomeViewModel.HomeState(
            coffees = listOf(
                Coffee(
                    id = 0,
                    title = "Test",
                    image = "image",
                    description = "test",
                    ingredients = emptyList()
                )
            ),
            errorMessage = ""
        )

        viewModel.getCoffees()

        val capturedStates = argumentCaptor<HomeViewModel.HomeState>()
        verify(observer, times(2)).onChanged(capturedStates.capture())

        assertEquals(correctState, capturedStates.secondValue) // Проверка, что список кофе успешно загружен
    }

    @Test
    fun `error message is empty`(){
        viewModel.getCoffees()

        val capturedStates = argumentCaptor<HomeViewModel.HomeState>()
        verify(observer, times(2)).onChanged(capturedStates.capture())

        assertEquals("", capturedStates.secondValue.errorMessage) // Проверка, что сообщение об ошибке пустое
    }


    @After
    fun shutdown(){
        viewModel.state.removeObserver(observer)
    }

}