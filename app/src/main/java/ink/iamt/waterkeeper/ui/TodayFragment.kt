package ink.iamt.waterkeeper.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ink.iamt.waterkeeper.R
import ink.iamt.waterkeeper.Record
import ink.iamt.waterkeeper.TodayViewModel
import kotlinx.android.synthetic.main.fragment_today.*
import java.time.OffsetDateTime

@AndroidEntryPoint
class TodayFragment : Fragment(R.layout.fragment_today) {
    private val model: TodayViewModel by viewModels()
    private lateinit var waterAdapter: TodayWaterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.todayAmount.observe(viewLifecycleOwner, Observer<Int> {
            tvDayWater.text = it.toString()
        })

        model.records.observe(viewLifecycleOwner, Observer { records ->
            tvDayWater.text = records.flatMap { listOf(it.amount) }.sum().toString()
            waterAdapter.submitList(records)
        })

        configAddButtons()
        configRecyclerView()
    }

    private fun configRecyclerView() {
        rvDayLog.apply {
            waterAdapter = TodayWaterAdapter()
            adapter = waterAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun configAddButtons() {
        btnAddSmall.setOnClickListener {
            model.insert(Record(time = OffsetDateTime.now(), amount = 123))
        }
    }

}