package shehovtsov.simplelogin.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import shehovtsov.simplelogin.room.RoomDB
import shehovtsov.simplelogin.room.entities.UserData
import shehovtsov.simplelogin.room.repository.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository
    private val shared = application.getSharedPreferences("authorization", Context.MODE_PRIVATE)
    val userShared: String


    init {
        val dao = RoomDB.getDatabase(application).userDao()
        repository = UserRepository(dao)
        userShared = shared.getString("userLogin", "").toString()
    }

    fun getUser(): LiveData<UserData?> {
        return repository.getUser(userShared).asLiveData()
            .map { list -> list.firstOrNull() }
    }

    fun logIn(login: String, password: String): LiveData<UserData?> {
        return repository.authorizeUser(login, password).asLiveData()
            .map { list -> list.firstOrNull() }
    }
}