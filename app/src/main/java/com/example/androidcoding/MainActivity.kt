package com.example.androidcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ListView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var userListView: ListView
    private lateinit var myFirstName: String
    private lateinit var myLastName: String
    private lateinit var myUserName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle : Bundle? = intent.extras
        myFirstName = bundle?.get("key_login_firstName").toString()
        myLastName = bundle?.get("key_login_lastName").toString()
        myUserName = bundle?.get("key_login_userName").toString()

        userListView = findViewById(R.id.lv)
        val userList = getUsers()
        val adapter = Adapter(this,userList)
        userListView.adapter = adapter

        userListView.setOnItemClickListener {
            parent, view, position, id ->
            val user = userList[position]
            Toast.makeText(this,"Click on ListItem recipe: "+user.getUserName(), Toast.LENGTH_LONG).show()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val myFragment = MyFragment()
            fragmentTransaction.add(R.id.fragment_container, myFragment)
            fragmentTransaction.commit()
        }
    }

    private fun getUsers():ArrayList<User> {
        val users : ArrayList<User> = ArrayList()
        users.add(User(myFirstName,myLastName,myUserName))
        users.add(User("Bob","Bob", "bob2"))
        users.add(User("John","Snow", "throne12"))
        return users
    }
}
