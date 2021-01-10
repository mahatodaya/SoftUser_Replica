package com.dayaram.week6_assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dayaram.week6_assignment1.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linearContainer, HomeFragment())
            addToBackStack(null)
            commit()
        }
    }
}