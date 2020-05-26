package com.example.androidcoding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MyFragment : Fragment() {
    lateinit var myText : EditText
    lateinit var myButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        myText = view.findViewById(R.id.edt_fragment)
        myButton = view.findViewById(R.id.btn_save)
        myButton.setOnClickListener {
            val intent = Intent (activity, NextActivity::class.java)
            val msg = myText.text.toString()
            intent.putExtra("key_msg", msg)
            activity?.startActivity(intent)
            Toast.makeText(activity,"Clicked Save", Toast.LENGTH_LONG).show()
        }
        return view
    }

}
