package com.mrapps.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mrapps.horizontalstackedchartview.LegendItem
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
        val legendItems = listOf(
            LegendItem(ContextCompat.getColor(this, R.color.purple_200), "People"),
            LegendItem(ContextCompat.getColor(this, R.color.purple_500), "Animal"),
            LegendItem(ContextCompat.getColor(this, R.color.green), "Trees"),
            LegendItem(ContextCompat.getColor(this, R.color.blue), "Ocean"),
            LegendItem(ContextCompat.getColor(this, R.color.red), "Zombies"),
            LegendItem(ContextCompat.getColor(this, R.color.maroon), "Aliens")
        )
        binding.chart.updateLegend(legendItems)
    }


}