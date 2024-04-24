package ru.akurbanoff.cart.ui.delivery

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.akurbanoff.cart.R

class DeliveryFragment : Fragment() {

    companion object {
        fun newInstance() = DeliveryFragment()
    }

    private val viewModel: DeliveryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_delivery, container, false)
    }
}