package ink.iamt.waterkeeper.db

import androidx.lifecycle.LiveData
import androidx.room.*
import ink.iamt.waterkeeper.Record
import java.time.OffsetDateTime

@Dao
interface WaterDao {
    @Insert
    suspend fun insertRecord(record: Record)

    @Update
    suspend fun updateRecord(record: Record)

    @Delete
    suspend fun deleteRecord(record: Record)

    @Query("SELECT * FROM Record WHERE time > :todayStart AND time < :todayEnd ORDER BY time DESC")
    fun getTodayRecords(
            todayStart: OffsetDateTime? = OffsetDateTime.now().withHour(0).withSecond(0),
            todayEnd: OffsetDateTime? = OffsetDateTime.now().withHour(23).withSecond(59)
    ): LiveData<List<Record>>
}