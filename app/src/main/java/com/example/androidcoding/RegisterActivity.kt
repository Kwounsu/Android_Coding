package com.example.androidcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            if (edt_confirmPassword.text.toString() == edt_password.text.toString()) {
                intent.putExtra("key_firstName", edt_firstName.text.toString())
                intent.putExtra("key_lastName",edt_lastName.text.toString())
                intent.putExtra("key_userName",edt_userName.text.toString())
                intent.putExtra("key_password",edt_password.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this,"Password not match!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
