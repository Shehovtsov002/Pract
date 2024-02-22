package shehovtsov.simplelogin.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import shehovtsov.simplelogin.room.RoomDB
import shehovtsov.simplelogin.room.entities.UserData
import shehovtsov.simplelogin.room.repository.UserRepository

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository
    private val shared = application.getSharedPreferences("authorization", Context.MODE_PRIVATE)

    init {
        val dao = RoomDB.getDatabase(application).userDao()
        repository = UserRepository(dao)
    }

    fun addUser(user: UserData) {
        viewModelScope.launch {
            repository.addUser(user)
        }
        with(shared.edit()){
            putString("userLogin", user.login)
            apply()
        }
    }
}