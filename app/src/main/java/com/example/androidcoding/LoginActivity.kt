package com.example.androidcoding

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val bundle:Bundle? = intent.extras
        val firstName = bundle?.get("key_firstName")
        val lastName = bundle?.get("key_lastName")
        val userName = bundle?.get("key_userName")
        val password = bundle?.get("key_password")
        edt_login_username.text = Editable.Factory.getInstance().newEditable(userName as CharSequence)
        edt_login_password.text = Editable.Factory.getInstance().newEditable(password as CharSequence)
        btn_signIn.setOnClickListener {
            intent = Intent(this,MainActivity::class.java)
            val newUserName = edt_login_username.text.toString()
            intent.putExtra("key_login_firstName", firstName.toString())
            intent.putExtra("key_login_lastName", lastName.toString())
            intent.putExtra("key_login_userName", newUserName)
            startActivity(intent)
        }
    }
}
