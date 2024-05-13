package com.mrapps.sample

import LegendAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mrapps.horizontalstackedchartview.Data
import com.mrapps.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val people = 100.00
    private val animal = 200.25
    private val trees = 50.32
    private val ocean = 20.00
    private val zombies = 30.00
    private val aliens = 40.00

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
            Data(1, getColor(R.color.purple_200), people, "People"),
            Data(2, getColor(R.color.purple_500), animal, "Animal"),
            Data(3, getColor(R.color.green), trees, "Trees"),
            Data(4, getColor(R.color.blue), ocean, "Ocean"),
            Data(5, getColor(R.color.red), zombies, "Zombies"),
            Data(6, getColor(R.color.maroon), aliens, "Aliens")
        )

        val legendAdapter = LegendAdapter(legendData)
        binding.legendRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.legendRecyclerView.adapter = legendAdapter
    }


}