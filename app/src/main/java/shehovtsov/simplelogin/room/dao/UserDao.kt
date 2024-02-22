package shehovtsov.simplelogin.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import shehovtsov.simplelogin.room.entities.UserData

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserData)


    @Query("SELECT * FROM user WHERE user.login LIKE :login")
    fun readUser(login: String) : Flow<List<UserData>>

    @Query("SELECT * FROM user WHERE user.login LIKE :login AND user.password LIKE :password")
    fun authorizeUser(login: String, password: String): Flow<List<UserData>>
}