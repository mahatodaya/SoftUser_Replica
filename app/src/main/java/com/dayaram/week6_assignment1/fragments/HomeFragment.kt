package com.dayaram.week6_assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dayaram.week6_assignment1.R
import com.dayaram.week6_assignment1.adapter.StudentAdapter
import com.dayaram.week6_assignment1.model.Student

class HomeFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private var lstStudents = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)

        loadStudents()

        val adapter = StudentAdapter(lstStudents, this)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        return view
    }

    private fun loadStudents(){
        lstStudents.add(Student(11, "https://cdn.kickoff.com/cms2/image_manager/uploads/News/690274/7/default.jpg",
            "Neymar Junior", 29, "France", "Male"
            ))
        lstStudents.add(Student(10, "https://pbs.twimg.com/media/EpHHc3JUwAIPjNA.jpg:large",
            "Lionel Messi", 34, "Spain","Male"
            ))
    }

}