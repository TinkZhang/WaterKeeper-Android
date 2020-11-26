package ink.iamt.waterkeeper

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodayViewModel @ViewModelInject constructor(private val repository: WaterRepository): ViewModel() {

    val todayAmount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    val records = repository.getTodayRecords()

    fun insert(record: Record) = viewModelScope.launch {
        repository.insertRecord(record)
    }
}