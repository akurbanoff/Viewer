package ru.akurbanoff.menu.ui.coffies

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.akurbanoff.menu.R

internal class CoffeesFragment : Fragment() {

    companion object {
        fun newInstance() = CoffeesFragment()
    }

    private val viewModel: CoffiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_coffies, container, false)
    }
}