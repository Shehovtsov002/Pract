package shehovtsov.simplelogin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import shehovtsov.simplelogin.room.dao.UserDao
import shehovtsov.simplelogin.room.entities.UserData

@Database(
    entities = [
        UserData::class
    ],
    version = 1,
    exportSchema = false
)
abstract class RoomDB: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(context: Context): RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "roomDb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}