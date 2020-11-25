package ink.iamt.waterkeeper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodayViewModel @ViewModelInject constructor(
        val waterRepository: WaterRepository
): ViewModel() {
    val todayAmount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    fun insert(record: Record) = viewModelScope.launch {
        waterRepository.insertRecord(record)
    }
}