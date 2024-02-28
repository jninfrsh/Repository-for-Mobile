package com.example.mangan.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.mangan.R
import android.widget.Toast


class login : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var db: database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button = findViewById(R.id.button)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        db = database(context = this)

        button.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Add Email & Password", Toast.LENGTH_SHORT).show()
            }
            else {
                val checkuser = db.checkUserPass(email, password)
                if (checkuser) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong Username & Password", Toast.LENGTH_SHORT).show()
                }
            }

            

        }
    }
}