package ubaya.example.habittracker.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubaya.example.habittracker.databinding.HabitItemBinding
import ubaya.example.habittracker.model.Habit

class HabitAdapter(private val habitList: ArrayList<Habit>)
    : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

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
        val habit = habitList[position]

        holder.binding.txtIcon.text = habit.icon
        holder.binding.txtHabitName.text = habit.name
        holder.binding.txtHabitDesc.text = habit.description
        holder.binding.txtHabitGoal.text = "${habit.progress}/${habit.goal}"
        holder.binding.progressHabit.max = habit.goal
        holder.binding.progressHabit.progress = habit.progress

        if (habit.progress >= habit.goal) {
            holder.binding.txtStatus.text = "Completed"
        } else {
            holder.binding.txtStatus.text = "In Progress"
        }

        holder.binding.btnPlus.setOnClickListener {
            if (habit.progress < habit.goal) {
                habit.progress++
                notifyItemChanged(position)
            }
        }

        holder.binding.btnMinus.setOnClickListener {
            if (habit.progress > 0) {
                habit.progress--
                notifyItemChanged(position)
            }
        }
    }

    fun updateHabitList(newHabitList: ArrayList<Habit>) {
        habitList.clear()
        habitList.addAll(newHabitList)
        notifyDataSetChanged()
    }
}