package com.mrapps.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrapps.horizontalstackedchartview.R.color
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
        setupBarSecond()

        setupLegend()
        setupLegendSecond()

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
        binding.chart.setLegend(binding.legendRecyclerView)
        binding.legendRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.chart.legendTextColor = getColor(color.default_legend_text_color)
        binding.chart.legendValueTextColor = getColor(color.default_legend_sub_text_color)
        binding.chart.legendTextSize = 15.5f
        binding.chart.legendValueTextSize = 12.5f
        binding.chart.legendDotHeight = 35f
        binding.chart.legendDotWidth = 35f
        binding.chart.legendDotCornerRadius = 8f
        binding.chart.legendValue = false
        binding.chart.legendValueShow = true
    }

    private fun setupBarSecond() {
        binding.chart2.addData(1, people, getColor(R.color.purple_200), "People")
        binding.chart2.addData(2, animal, getColor(R.color.purple_500), "Animal")
        binding.chart2.addData(3, trees, getColor(R.color.green), "Trees")
        binding.chart2.addData(4, ocean, getColor(R.color.blue), "Ocean")
        binding.chart2.addData(5, zombies, getColor(R.color.red), "Zombies")
        binding.chart2.addData(6, aliens, getColor(R.color.maroon), "Aliens")
    }

    private fun setupLegendSecond() {
        binding.chart2.setLegend(binding.legendRecyclerView2)
        binding.legendRecyclerView2.layoutManager = LinearLayoutManager(this)
        binding.chart2.legendTextColor = getColor(color.default_legend_text_color)
        binding.chart2.legendValueTextColor = getColor(color.default_legend_sub_text_color)
        binding.chart2.legendTextSize = 15.5f
        binding.chart2.legendValueTextSize = 12.5f
        binding.chart2.legendDotHeight = 20f
        binding.chart2.legendDotWidth = 40f
        binding.chart2.legendDotCornerRadius = 10f
        binding.chart2.legendValue = true
        binding.chart2.legendValueShow = true
    }


}