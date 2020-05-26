package com.example.androidcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        buttonToLogin.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("key_firstName", "Null")
            intent.putExtra("key_lastName","Null")
            intent.putExtra("key_userName","Null")
            intent.putExtra("key_password","Null")
            startActivity(intent)
        }
        buttonToRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
