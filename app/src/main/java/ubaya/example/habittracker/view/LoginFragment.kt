package ubaya.example.habittracker.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ubaya.example.habittracker.R
import ubaya.example.habittracker.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()

            if (username == "student" && password == "123") {
                Navigation.findNavController(it).navigate(R.id.actionDashboardFragment)
            } else {
                binding.txtError.visibility = View.VISIBLE
                binding.txtError.text = "Username atau password salah"
            }
        }
    }
}