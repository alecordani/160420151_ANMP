package ubaya.example.habittracker.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import ubaya.example.habittracker.R
import ubaya.example.habittracker.databinding.FragmentEditHabitBinding
import ubaya.example.habittracker.model.Habit
import ubaya.example.habittracker.viewmodel.HabitViewModel

class EditHabitFragment : Fragment(R.layout.fragment_edit_habit) {

    private lateinit var binding: FragmentEditHabitBinding
    private lateinit var viewModel: HabitViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEditHabitBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[HabitViewModel::class.java]

        val habit = arguments?.getSerializable("habit") as? Habit

        if (habit != null) {
            binding.habit = habit

            binding.btnUpdateHabit.setOnClickListener {

                habit.name = binding.txtEditHabitName.text.toString()
                habit.description = binding.txtEditHabitDescription.text.toString()
                habit.goal = binding.txtEditHabitGoal.text.toString().toIntOrNull() ?: 0
                habit.icon = binding.txtEditHabitIcon.text.toString()

                viewModel.updateHabit(habit)

                Navigation.findNavController(it).popBackStack()
            }
        }
    }
}