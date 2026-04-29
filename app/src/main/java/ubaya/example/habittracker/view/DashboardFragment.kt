package ubaya.example.habittracker.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import ubaya.example.habittracker.R
import ubaya.example.habittracker.databinding.FragmentDashboardBinding
import ubaya.example.habittracker.viewmodel.HabitViewModel

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: HabitViewModel
    private val habitAdapter = HabitAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDashboardBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[HabitViewModel::class.java]

        binding.recHabit.layoutManager = LinearLayoutManager(context)
        binding.recHabit.adapter = habitAdapter

        observeViewModel()
        viewModel.loadHabits()

        binding.fabAdd.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionCreateHabitFragment)
        }
    }

    private fun observeViewModel() {
        viewModel.habitsLD.observe(viewLifecycleOwner) {
            habitAdapter.updateHabitList(it)
        }
    }
}