package com.dayaram.week6_assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var pbLogin: ProgressBar
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Binding
        etUsername = findViewById(R.id.etLoginUsername)
        etPassword = findViewById(R.id.etLoginPassword)
        pbLogin = findViewById(R.id.pbLogin)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            if (setValidation()) {
                login()
            }
        }
    }

    // Function to login with valid username and password
    private fun login() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Set up username and password
        if (username == "softwarica" && password == "coventry") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            pbLogin.visibility = View.VISIBLE
        } else {
            clearText()
        }
    }

    // Function to clear text box
    private fun clearText() {
        etUsername.setText("")
        etPassword.setText("")
        Toast.makeText(this, "Please enter valid username or password", Toast.LENGTH_LONG).show()
        etUsername.requestFocus()
    }

    // Function to check for validation
    private fun setValidation(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etUsername.text) -> {
                etUsername.error = "Please enter username"
                etUsername.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etPassword.text) -> {
                etPassword.error = "Please enter password"
                etPassword.requestFocus()
                flag = false
            }
        }
        return flag
    }
}