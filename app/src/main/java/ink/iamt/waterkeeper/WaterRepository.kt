package ink.iamt.waterkeeper

import ink.iamt.waterkeeper.db.WaterDao
import javax.inject.Inject

class WaterRepository @Inject constructor(
        val waterDao: WaterDao
){
    suspend fun insertRecord(record: Record) = waterDao.insertRecord(record)
}