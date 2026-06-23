package ubaya.example.habittracker.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HabitDao {

    @Insert
    fun insertAll(vararg habit: Habit)

    @Query("SELECT * FROM habits")
    fun selectAllHabit(): List<Habit>

    @Update
    fun updateHabit(habit: Habit)
}