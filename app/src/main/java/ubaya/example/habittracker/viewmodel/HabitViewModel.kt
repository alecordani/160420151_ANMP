package ubaya.example.habittracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ubaya.example.habittracker.model.Habit
import ubaya.example.habittracker.model.HabitRepository

class HabitViewModel : ViewModel() {

    val habitsLD = MutableLiveData<ArrayList<Habit>>()

    fun loadHabits() {
        habitsLD.value = HabitRepository.habitList
    }

    fun addHabit(habit: Habit) {
        HabitRepository.habitList.add(habit)
        habitsLD.value = HabitRepository.habitList
    }
}