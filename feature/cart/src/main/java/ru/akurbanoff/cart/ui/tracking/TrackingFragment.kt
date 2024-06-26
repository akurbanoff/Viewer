package ru.akurbanoff.cart.ui.tracking

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.akurbanoff.cart.R

internal class TrackingFragment : Fragment() {

    companion object {
        fun newInstance() = TrackingFragment()
    }

    private val viewModel: TrackingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_tracking, container, false)
    }
}