
package ru.akurbanoff.home.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.akurbanoff.home.R
import ru.akurbanoff.home.di.HomeDepsStore
import ru.akurbanoff.home.di.HomeViewModelComponent

class HomeFragment : Fragment(R.layout.fragment_home) {
    //private val binding: FragmentHomeBinding by viewBinding()
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeComponent = HomeViewModelComponent().homeComponent

        val viewModel = homeComponent.homeViewModel.create()
        val page = 1
        val coffeeList = viewModel.getCoffees(page = page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}