package com.mrapps.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mrapps.horizontalstackedbarview.Data
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

    private val dataList: MutableList<Data> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setupBar()
        setupLegend()

        Log.e("main", "onCreate: ${dataList.size}")

    }

    private fun setupBar() {
        binding.chart.addData(1, people, getColor(R.color.purple_200), "People")
        binding.chart.addData(2, animal, getColor(R.color.purple_500), "Animal")
        binding.chart.addData(3, trees, getColor(R.color.green), "Trees")
        binding.chart.addData(4, ocean, getColor(R.color.blue), "Ocean")
        binding.chart.addData(5, zombies, getColor(R.color.red), "Zombies")
        binding.chart.addData(6, aliens, getColor(R.color.maroon), "Aliens")

        Log.e("main", "setupBar: ${dataList.size}")
    }

    private fun setupLegend() {
        binding.chart.setLegendView(binding.legendView)
//        binding.legendView.setLegendHorizontal = true
        binding.legendView.setHorizontalSpanCount = 2
//        binding.legendView.legendTextColor = getColor(color.default_legend_text_color)
//        binding.legendView.legendValueTextColor = getColor(color.default_legend_sub_text_color)
//        binding.legendView.legendTextSize = 15.5f
//        binding.legendView.legendValueTextSize = 12.5f
//        binding.legendView.legendDotHeight = 35f
//        binding.legendView.legendDotWidth = 35f
//        binding.legendView.legendDotCornerRadius = 8f
//        binding.legendView.legendDotSpacing = 20.8995f
//        binding.legendView.legendValueSpacing = 21.22550f
//        binding.legendView.legendValue = false
//        binding.legendView.legendValueShow = true

        Log.e("main", "setupLegend: ${dataList.size}")

    }

}