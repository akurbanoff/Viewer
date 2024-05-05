
package ru.akurbanoff.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.akurbanoff.home.R
import ru.akurbanoff.home.data.models.Coffee
import ru.akurbanoff.home.databinding.FragmentHomeBinding
import ru.akurbanoff.home.di.HomeViewModelComponent
import ru.akurbanoff.home.ui.items.FrequentlyOrderedListAdapter
import ru.akurbanoff.home.ui.items.NewInRowAdapter

class HomeFragment :
    Fragment(R.layout.fragment_home),
    NewInRowAdapter.Callback,
    FrequentlyOrderedListAdapter.Callback
{
    private val binding: FragmentHomeBinding by viewBinding()
    private lateinit var viewModel: HomeViewModel
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCoffees()

        viewModel.state.observe(viewLifecycleOwner){
            //if(it.errorMessage.isNotEmpty()) handleError(it.errorMessage)
            //if(it.coffees.isNotEmpty())
            handleData(it.coffees)
        }

    }

    fun handleError(errorMessage: String){

    }

    fun handleData(list: List<Coffee>){
        val newInAdapter = NewInRowAdapter()
        newInAdapter.setData(list)
        newInAdapter.setCallback(this)

        val newInManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.newInRecycleRow.also {
            it.hasFixedSize()
            it.adapter = newInAdapter
            it.layoutManager = newInManager
        }

        val frequentlyOrderedAdapter = FrequentlyOrderedListAdapter()
        frequentlyOrderedAdapter.setData(list)
        frequentlyOrderedAdapter.setCallback(this)
        val frequentlyOrderedManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.frequentelyOrderedList.also {
            it.hasFixedSize()
            it.adapter = frequentlyOrderedAdapter
            it.layoutManager = frequentlyOrderedManager
        }
    }

    override fun onClickItem(item: Coffee) {
        val navController = findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeComponent = HomeViewModelComponent().homeComponent
        viewModel = homeComponent.homeViewModel.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}