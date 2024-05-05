package ru.akurbanoff.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import ru.akurbanoff.core.NetworkState
import ru.akurbanoff.home.data.api.CoffeeApi
import ru.akurbanoff.home.data.models.Coffee
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

class CoffeeUseCase @Inject constructor(
    val coffeeApi: CoffeeApi
) {
    fun getCoffees() : Single<Response<List<Coffee>>>{
        return coffeeApi.getCoffees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
//            .cache()
//            .map {
//                it.body()?.forEach {
//                    it.price = Random.nextInt(0..10)
//                }
//                it
//            }
    }
//    fun getCoffees(): NetworkState{
//        return runCatching {
//            coffeeApi.getCoffees()
//        }.mapCatching { response ->
//            if(response.isSuccessful){
//                NetworkState.Success(response.body() ?: emptyList())
//            } else {
//                NetworkState.ServerError(response.errorBody()?.string() ?: "Something went wrong")
//            }
//        }.getOrElse(NetworkState::Error)
//    }
}