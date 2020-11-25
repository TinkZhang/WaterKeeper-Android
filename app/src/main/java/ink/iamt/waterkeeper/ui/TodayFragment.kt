package ink.iamt.waterkeeper.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ink.iamt.waterkeeper.R
import ink.iamt.waterkeeper.Record
import ink.iamt.waterkeeper.TodayViewModel
import kotlinx.android.synthetic.main.fragment_today.*
import java.time.OffsetDateTime

class TodayFragment : Fragment(R.layout.fragment_today) {
    val model: TodayViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.todayAmount.observe(viewLifecycleOwner, Observer<Int> {
            tvDayWater.text = it.toString()
        })

        configAddButtons()
    }

    private fun configAddButtons() {
        btnAddSmall.setOnClickListener {
            model.todayAmount.value = model.todayAmount.value?.plus(100)
            model.insert(Record(time = OffsetDateTime.now(), amount = 123))
        }
    }

}