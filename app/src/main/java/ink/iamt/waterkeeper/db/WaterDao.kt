package ink.iamt.waterkeeper.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import ink.iamt.waterkeeper.Record

@Dao
interface WaterDao {
    @Insert
    suspend fun insertRecord(record: Record)

    @Update
    suspend fun updateRecord(record: Record)

    @Delete
    suspend fun deleteRecord(record: Record)
}