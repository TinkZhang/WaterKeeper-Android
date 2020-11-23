package ink.iamt.waterkeeper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodayViewModel : ViewModel() {
    val todayAmount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
}