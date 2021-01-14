package com.dayaram.week6_assignment1.fragments

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

    private lateinit var spImgProfile: Spinner
    private lateinit var etFullName: EditText
    private lateinit var etAge: EditText
    private lateinit var rdoGender: RadioGroup
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var pbSave: ProgressBar
    private lateinit var btnSave: Button

    private val profileImage = arrayOf(
            "Paul Shah" , "https://www.nepalitrends.com/wp-content/uploads/2018/01/Paul-Shah.jpg",
            "Sabitra Bhandari",  "https://www.goalnepal.com/uploads/news/1575547345.jpg",
            "Kiran Chemjong" , "https://www.nepaligoal.com/wp-content/uploads/2016/01/Kiran-Chemjong.jpg",
            "Sushant Khatri" , "https://www.nepalitrends.com/wp-content/uploads/2018/05/29389202_1657650554329868_969951466522432452_n-e1525455906640-760x456.jpg",
            "Swastima Khadka" , "https://lugako.com/wp-content/uploads/2019/03/17931997_280067729110364_2098065994810392576_n-e1551595766757-749x600.jpg",
            "Bharat Khawas" , "https://goalnepal.com/uploads/news/1546954013.png",
            "Paras Khadka" , "https://thehimalayantimes.com/wp-content/uploads/2017/04/Paras-Khadka-celebrates-scoring-50-runs.jpg",
            "Alisha Sharma" , "https://lh3.googleusercontent.com/proxy/L0XZgXwdk0abuwnBn7HOpEPsRnP-_LRArBZeKjH8NceWXCAalJs6k0N7lg6qY4g81du3gotAvsGlBpX99ISYXn1WH5pKI-1cO1Wq3ix4tow83PIaiDjDlhJi6iXTsxfzuS5OsBke1kH2",
            "Sandeep Lamichhane" , "https://www.cricket.com.au/-/media/News/2018/12/20Sandeep.ashx"
    )

    var selectedImage = ""

    val students = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student, container, false)

        spImgProfile = view.findViewById(R.id.imgProfile)
        etFullName = view.findViewById(R.id.etFullName)
        etAge = view.findViewById(R.id.etAge)
        rdoGender = view.findViewById(R.id.rdoGender)
        rdoMale = view.findViewById(R.id.rdoMale)
        rdoFemale = view.findViewById(R.id.rdoFemale)
        rdoOthers = view.findViewById(R.id.rdoOthers)
        etAddress = view.findViewById(R.id.etAddress)
        pbSave = view.findViewById(R.id.pbSave)
        btnSave = view.findViewById(R.id.btnSave)
        adapter()


        btnSave.setOnClickListener {
            // pbSave.visibility = View.VISIBLE
            Toast.makeText(view.context, "Student not added", Toast.LENGTH_LONG).show()


            val fullName = etFullName.text.toString()
            val age = etAge.text.toString().toInt()
            val address = etAddress.text.toString()
            val checkedId = rdoGender.checkedRadioButtonId
            val checkRB: RadioButton = view.findViewById(checkedId)
            val gender = checkRB.text.toString()

            StudentData.studentData.add(Student( selectedImage ,fullName, age, address, gender))



//            val intent = Intent(this, Lab07OutputActivity::class.java)
//            intent.putExtra("students", Student(name, address, mobileNumber, sex ))
//            setResult(Activity.RESULT_OK,intent)
//            finish()

            // students.add(Student(fullName, age, address, gender ))




        }
        return view
    }

    private fun adapter(){

        val imageURL = mutableMapOf<String, String>()
        for ( i in profileImage.indices step 2){
            imageURL[profileImage[i]] = profileImage[i + 1]
        }

        val profile = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_list_item_1,
                    imageURL.keys.toTypedArray())
        }
        spImgProfile.adapter = profile

        spImgProfile.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val image = parent?.getItemAtPosition(position).toString()
                selectedImage = imageURL[image].toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}