package shehovtsov.simplelogin.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val login: String,
    val password: String
)