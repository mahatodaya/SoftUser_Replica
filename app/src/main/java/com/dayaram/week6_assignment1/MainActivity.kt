package com.dayaram.week6_assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dayaram.week6_assignment1.fragments.HomeFragment
import com.dayaram.week6_assignment1.model.Student
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)

        loadStudents()
    }

    // Function to display to static data.
    private fun loadStudents() {
        StudentData.studentData.add(Student(
                "https://www.nepalitrends.com/wp-content/uploads/2018/01/Paul-Shah.jpg",
                "Paul Shah", 27, "Baneshwor", "Male"
        ))
        StudentData.studentData.add(Student(
                "https://www.goalnepal.com/uploads/news/1575547345.jpg",
                "Sabitra Bhandari", 25, "Lagankhel", "Female"
        ))
    }
}