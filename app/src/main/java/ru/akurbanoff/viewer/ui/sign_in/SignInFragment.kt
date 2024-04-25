package ru.akurbanoff.viewer.ui.sign_in

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.akurbanoff.viewer.R
import ru.akurbanoff.viewer.databinding.FragmentSignInBinding

class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private val binding: FragmentSignInBinding by viewBinding()
    private val viewModel: SignInViewModel by viewModels()
    private lateinit var navController: NavController

    companion object {
        fun newInstance() = SignInFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            navController.navigate(SignInFragmentDirections.actionSignInFragmentToRegisterFragment())
        }

        binding.goToRegister.setOnClickListener {
            navController.navigate(SignInFragmentDirections.actionSignInFragmentToRegisterFragment())
        }

        binding.loginButton.setOnClickListener {
            navController.navigate(SignInFragmentDirections.actionSignInFragmentToHomeFragment())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }
}