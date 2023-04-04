package com.epsi.mdhgmn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        showBack()

        val firstName = intent.extras?.getString("firstName")
        val lastName = intent.extras?.getString("lastName")
        val email = intent.extras?.getString("email")
        val name = "$firstName $lastName"

        val combinedNameTextView = findViewById<TextView>(R.id.student_name)
        combinedNameTextView.text = name

        val emailTextView = findViewById<TextView>(R.id.email)
        emailTextView.text = email

        val groupTextView = findViewById<TextView>(R.id.group)
        groupTextView.text = "MDH-GMN"

        setHeaderTitle(firstName)
    }
}