package com.mrapps.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrapps.horizontalstackedbarview.R.color
import com.mrapps.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val people = 50.00
    private val animal = 100.25
    private val trees = 50.32
    private val ocean = 200.20
    private val zombies = 30.00
    private val aliens = 40.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setupBar()
        setupBar2()
        setupLegend()
        setupLegend2()

    }

    private fun setupBar() {
        binding.chart.addData(1, people, getColor(R.color.purple_500), "People")
        binding.chart.addData(2, animal, getColor(R.color.purple_200), "Animal")
        binding.chart.addData(3, trees, getColor(R.color.green), "Trees")
        binding.chart.addData(4, ocean, getColor(R.color.blue), "Ocean")
        binding.chart.addData(5, zombies, getColor(R.color.red), "Zombies")
        binding.chart.addData(6, aliens, getColor(R.color.maroon), "Aliens")

    }

    private fun setupBar2() {
        binding.chart2.addData(1, people, getColor(R.color.purple_200), "People")
        binding.chart2.addData(2, animal, getColor(R.color.purple_500), "Animal")
        binding.chart2.addData(3, trees, getColor(R.color.green), "Trees")
        binding.chart2.addData(4, ocean, getColor(R.color.blue), "Ocean")
        binding.chart2.addData(5, zombies, getColor(R.color.red), "Zombies")
        binding.chart2.addData(6, aliens, getColor(R.color.maroon), "Aliens")

    }

    private fun setupLegend() {
        binding.chart.setLegendView(binding.legendView)
        binding.legendView.setLegendHorizontal = true
        binding.legendView.setHorizontalSpanCount = 2
        binding.legendView.legendTextColor = getColor(color.default_legend_text_color)
        binding.legendView.legendValueTextColor = getColor(color.default_legend_sub_text_color)
        binding.legendView.legendTextSize = 15.5f
        binding.legendView.legendValueTextSize = 12.5f
        binding.legendView.legendDotHeight = 35f
        binding.legendView.legendDotWidth = 35f
        binding.legendView.legendDotCornerRadius = 8f
        binding.legendView.legendDotSpacing = 20.8995f
        binding.legendView.legendValueSpacing = 21.22550f
        binding.legendView.legendItemSpace = 8.5f
        binding.legendView.legendValue = false
        binding.legendView.legendValueShow = true

    }

    private fun setupLegend2() {
        binding.chart2.setLegendView(binding.legendView2)
        binding.legendView2.setLegendHorizontal = false
        binding.legendView2.legendTextColor = getColor(color.default_legend_text_color)
        binding.legendView2.legendValueTextColor = getColor(color.default_legend_sub_text_color)
        binding.legendView2.legendTextSize = 15.5f
        binding.legendView2.legendValueTextSize = 12.5f
        binding.legendView2.legendDotHeight = 20f
        binding.legendView2.legendDotWidth = 35f
        binding.legendView2.legendDotCornerRadius = 8f
        binding.legendView2.legendDotSpacing = 25.8995f
        binding.legendView2.legendValueSpacing = 20.22550f
        binding.legendView2.legendItemSpace = 40.5f
        binding.legendView2.legendValue = true
        binding.legendView2.legendValueShow = true
    }


}