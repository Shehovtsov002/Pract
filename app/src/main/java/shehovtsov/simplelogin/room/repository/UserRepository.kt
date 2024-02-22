package shehovtsov.simplelogin.room.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import shehovtsov.simplelogin.room.dao.UserDao
import shehovtsov.simplelogin.room.entities.UserData

class UserRepository(
    private val userDao: UserDao
) {
    fun getUser(login: String): Flow<List<UserData>> {
        return userDao.readUser(login)
    }
    fun authorizeUser(login: String, password: String): Flow<List<UserData>> {
        return userDao.authorizeUser(login, password)
    }

    suspend fun addUser(user: UserData){
        userDao.insertUser(user)
    }
}