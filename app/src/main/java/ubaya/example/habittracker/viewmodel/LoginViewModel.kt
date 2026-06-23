package ubaya.example.habittracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ubaya.example.habittracker.model.HabitDatabase
import ubaya.example.habittracker.model.User
import kotlin.coroutines.CoroutineContext

class LoginViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {

    val loginSuccessLD = MutableLiveData<Boolean>()

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun login(username: String, password: String) {
        launch {
            val db = HabitDatabase.buildDatabase(getApplication())
            val user = db.userDao().login(username, password)

            if (user != null) {
                loginSuccessLD.postValue(true)
            } else {
                loginSuccessLD.postValue(false)
            }
        }
    }

    fun insertDefaultUser() {
        launch {
            val db = HabitDatabase.buildDatabase(getApplication())
            val user = db.userDao().login("student", "123")

            if (user == null) {
                db.userDao().insertAll(
                    User("student", "123")
                )
            }
        }
    }
}