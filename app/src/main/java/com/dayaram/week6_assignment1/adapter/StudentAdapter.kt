package com.dayaram.week6_assignment1.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dayaram.week6_assignment1.R
import com.dayaram.week6_assignment1.StudentData
import com.dayaram.week6_assignment1.fragments.HomeFragment
import com.dayaram.week6_assignment1.model.Student

class StudentAdapter(
        private val lstStudents: ArrayList<Student>,
        private val context: HomeFragment,

        ) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Referencing
        val imgProfile: ImageView = view.findViewById(R.id.imageProfile)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAge: TextView = view.findViewById(R.id.tvAge)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
        val tvGender: TextView = view.findViewById(R.id.tvGender)
        val deleteImgBtn: ImageButton = view.findViewById(R.id.imgBtnDelete)
    }

    // Populate Design
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    // Populate Data
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudents[position]
        holder.tvName.text = student.name
        holder.tvAge.text = student.age.toString()
        holder.tvAddress.text = student.address
        holder.tvGender.text = student.gender

        // For Delete
        holder.deleteImgBtn.setOnClickListener {
            StudentData.studentData.removeAt(position)
            this.notifyDataSetChanged()
        }

        // Load Image
        Glide.with(context)
                .load(student.imgProfile)
                .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}