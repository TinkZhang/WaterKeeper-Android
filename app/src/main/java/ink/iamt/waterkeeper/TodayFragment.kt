package ink.iamt.waterkeeper

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_today.*

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
        }
    }

}