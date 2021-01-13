package com.dayaram.week6_assignment1.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.dayaram.week6_assignment1.R
import com.dayaram.week6_assignment1.StudentData
import com.dayaram.week6_assignment1.model.Student


class StudentFragment : Fragment() {

    private lateinit var etFullName: EditText
    private lateinit var etAge: EditText
    private lateinit var rdoGender: RadioGroup
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var pbSave: ProgressBar
    private lateinit var btnSave: Button
    val students = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student, container, false)

        etFullName = view.findViewById(R.id.etFullName)
        etAge = view.findViewById(R.id.etAge)
        rdoGender = view.findViewById(R.id.rdoGender)
        rdoMale = view.findViewById(R.id.rdoMale)
        rdoFemale = view.findViewById(R.id.rdoFemale)
        rdoOthers = view.findViewById(R.id.rdoOthers)
        etAddress = view.findViewById(R.id.etAddress)
        pbSave = view.findViewById(R.id.pbSave)
        btnSave = view.findViewById(R.id.btnSave)


        btnSave.setOnClickListener {
            // pbSave.visibility = View.VISIBLE
            Toast.makeText(view.context, "Student not added", Toast.LENGTH_LONG).show()

            val fullName = etFullName.text.toString()
            val age = etAge.text.toString().toInt()
            val address = etAddress.text.toString()
            val checkedId = rdoGender.checkedRadioButtonId
            val checkRB: RadioButton = view.findViewById(checkedId)
            val gender = checkRB.text.toString()

            StudentData.studentData.add(Student(fullName, age, address, gender))



//            val intent = Intent(this, Lab07OutputActivity::class.java)
//            intent.putExtra("students", Student(name, address, mobileNumber, sex ))
//            setResult(Activity.RESULT_OK,intent)
//            finish()

            // students.add(Student(fullName, age, address, gender ))




        }
        return view
    }
}