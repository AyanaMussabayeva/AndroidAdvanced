package com.example.amanzholt.lesson4

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPref = this.getSharedPreferences("data", Context.MODE_PRIVATE)

        loginBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            sharedPref.edit().putString("login", emailEdit.text.toString()).apply()
        }
    }
}
