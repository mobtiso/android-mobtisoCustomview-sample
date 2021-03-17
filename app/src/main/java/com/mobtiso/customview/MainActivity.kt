package com.mobtiso.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobtiso.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        // Click for parent view
        binding.viewCustom.setOnClickListener {
            Toast.makeText(this, "click Parent View", Toast.LENGTH_SHORT).show()
        }
        // Click for button on custom view
        binding.viewCustom.onClick(object : CustomViewCallback {
            override fun onClick(value: String) {
                Toast.makeText(this@MainActivity, value, Toast.LENGTH_SHORT).show()
            }
        })
    }
}