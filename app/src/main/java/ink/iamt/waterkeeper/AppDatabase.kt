package ink.iamt.waterkeeper

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(Record::class), version = 1)
@TypeConverters(WaterTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun waterDao(): WaterDao
}