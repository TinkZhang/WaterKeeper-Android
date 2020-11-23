package ink.iamt.waterkeeper

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity
data class Record (
    @PrimaryKey val id: Int,
    val time: OffsetDateTime? = null,
    val amount: Int
)