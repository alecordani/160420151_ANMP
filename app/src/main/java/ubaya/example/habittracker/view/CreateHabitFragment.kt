package ubaya.example.habittracker.view

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import ubaya.example.habittracker.R
import ubaya.example.habittracker.databinding.FragmentCreateHabitBinding
import ubaya.example.habittracker.model.Habit
import ubaya.example.habittracker.viewmodel.HabitViewModel

class CreateHabitFragment : Fragment(R.layout.fragment_create_habit) {

    private lateinit var binding: FragmentCreateHabitBinding
    private lateinit var viewModel: HabitViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCreateHabitBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[HabitViewModel::class.java]

        val icons = arrayOf("💧", "🏃", "📚", "🧘", "💪")

        val iconAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            icons
        )

        iconAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerIcon.adapter = iconAdapter

        binding.btnCreateHabit.setOnClickListener {
            val name = binding.txtHabitName.text.toString()
            val description = binding.txtHabitDescription.text.toString()
            val goal = binding.txtHabitGoal.text.toString().toIntOrNull() ?: 0
            val icon = binding.spinnerIcon.selectedItem.toString()

            val newHabit = Habit(
                name,
                description,
                goal,
                0,
                icon
            )

            viewModel.addHabit(newHabit)

            Navigation.findNavController(it).popBackStack()
        }
    }
}