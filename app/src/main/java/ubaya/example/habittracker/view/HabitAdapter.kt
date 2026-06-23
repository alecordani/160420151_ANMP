package ubaya.example.habittracker.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubaya.example.habittracker.databinding.HabitItemBinding
import ubaya.example.habittracker.model.Habit

class HabitAdapter(
    private val habitList: ArrayList<Habit>,
    private val listener: HabitClickListener
) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    interface HabitClickListener {
        fun onPlusClick(habit: Habit)
        fun onMinusClick(habit: Habit)
        fun onHabitTitleClick(habit: Habit)
    }

    class HabitViewHolder(var binding: HabitItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = HabitItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HabitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return habitList.size
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        holder.binding.habit = habitList[position]
        holder.binding.listener = listener
        holder.binding.executePendingBindings()
    }

    fun updateHabitList(newHabitList: ArrayList<Habit>) {
        habitList.clear()
        habitList.addAll(newHabitList)
        notifyDataSetChanged()
    }
}