package ubaya.example.habittracker.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertAll(vararg user: User)

    @Query("SELECT * FROM users WHERE username=:username AND password=:password LIMIT 1")
    fun login(username: String, password: String): User?
}