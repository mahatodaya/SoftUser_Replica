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
        val lstStudents: ArrayList<Student>,
        val context: HomeFragment,

) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val imgProfile: ImageView
        val tvname : TextView
        val tvage : TextView
        val tvaddress : TextView
        val tvgender : TextView
        val deleteImgBtn : ImageButton

        init {
            imgProfile = view.findViewById(R.id.imageProfile)
            tvname = view.findViewById(R.id.tvName)
            tvage = view.findViewById(R.id.tvAge)
            tvaddress = view.findViewById(R.id.tvAddress)
            tvgender = view.findViewById(R.id.tvGender)
            deleteImgBtn = view.findViewById(R.id.imgBtnDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudents[position]
        holder.tvname.text = student.name
        holder.tvage.text = student.age.toString()
        holder.tvaddress.text = student.address
        holder.tvgender.text = student.gender

        holder.deleteImgBtn.setOnClickListener {
            StudentData.studentData.removeAt(position)
            Log.d("JJJJ", "clicked")
            this.notifyDataSetChanged()
        }

        Glide.with(context)
            .load(student.imgProfile)
            .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}