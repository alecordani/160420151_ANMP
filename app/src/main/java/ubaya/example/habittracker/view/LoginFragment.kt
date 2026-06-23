package ubaya.example.habittracker.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import ubaya.example.habittracker.R
import ubaya.example.habittracker.databinding.FragmentLoginBinding
import ubaya.example.habittracker.viewmodel.LoginViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        viewModel.insertDefaultUser()

        viewModel.loginSuccessLD.observe(viewLifecycleOwner) {
            if (it == true) {
                Navigation.findNavController(view).navigate(R.id.actionDashboardFragment)
            } else {
                binding.txtError.visibility = View.VISIBLE
                binding.txtError.text = "Username atau password salah"
            }
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()

            viewModel.login(username, password)
        }
    }
}