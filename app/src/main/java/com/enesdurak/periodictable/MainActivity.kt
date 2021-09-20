package com.enesdurak.periodictable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enesdurak.periodictable.data.mock.MockDataGenerator
import com.enesdurak.periodictable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val adapter = ElementListAdapter()
        adapter.elementList = MockDataGenerator.generateElementList(126)
        binding.rvElementList.adapter = adapter
        binding.rvElementList.layoutManager =
            GridLayoutManager(this, 7, RecyclerView.HORIZONTAL, false)

    }
}