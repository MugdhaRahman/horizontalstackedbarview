package com.mrapps.sample

import LegendAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrapps.horizontalstackedchartview.Data
import com.mrapps.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val people = 100.00
    val animal = 200.25
    val trees = 50.32
    val ocean = 20.00
    val zombies = 30.00
    val aliens = 40.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBar()
        setupLegend()

    }

    private fun setupBar() {
        binding.chart.addData(1, people, getColor(R.color.purple_200), "People")
        binding.chart.addData(2, animal, getColor(R.color.purple_500), "Animal")
        binding.chart.addData(3, trees, getColor(R.color.green), "Trees")
        binding.chart.addData(4, ocean, getColor(R.color.blue), "Ocean")
        binding.chart.addData(5, zombies, getColor(R.color.red), "Zombies")
        binding.chart.addData(6, aliens, getColor(R.color.maroon), "Aliens")
    }

    private fun setupLegend() {
        val legendData = listOf(
            Data(1, getColor(R.color.purple_200), 0.0, "People"),
            Data(2, getColor(R.color.purple_500), 0.0, "Animal"),
            Data(3, getColor(R.color.green), 0.0, "Trees"),
            Data(4, getColor(R.color.blue), 0.0, "Ocean"),
            Data(5, getColor(R.color.red), 0.0, "Zombies"),
            Data(6, getColor(R.color.maroon), 0.0, "Aliens")
        )

        val legendAdapter = LegendAdapter(legendData)
        binding.legendRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.legendRecyclerView.adapter = legendAdapter
    }


}