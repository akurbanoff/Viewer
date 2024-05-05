package ru.akurbanoff.feature.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.akurbanoff.feature.R
import ru.akurbanoff.feature.databinding.FragmentFeatureBottomBarBinding


class FeatureBottomBarFragment : Fragment(R.layout.fragment_feature_bottom_bar) {
    private val binding: FragmentFeatureBottomBarBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager.findFragmentById(R.id.containerOnBottomNavigation) as NavHostFragment
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, navHost.navController)
            return@setOnItemSelectedListener true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature_bottom_bar, container, false)
    }
}