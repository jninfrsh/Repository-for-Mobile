package com.example.mangan.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mangan.R
import android.widget.EditText
import android.text.TextUtils
import android.widget.Toast
import android.content.Intent
import android.widget.Button

class signup : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var db: database
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        db = database(context = this)

        button.setOnClickListener {
            val name = name.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()
            val savedata = db.insertData(name, email)

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Add Name, Email & Password", Toast.LENGTH_SHORT).show()
            } else {
                if (email == password) {
                    if (savedata) {
                        Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, signup::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Email Exists", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}

