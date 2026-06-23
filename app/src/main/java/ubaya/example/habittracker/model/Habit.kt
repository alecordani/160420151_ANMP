package ubaya.example.habittracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "habits")
data class Habit(
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "goal")
    var goal: Int,

    @ColumnInfo(name = "progress")
    var progress: Int = 0,

    @ColumnInfo(name = "icon")
    var icon: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}