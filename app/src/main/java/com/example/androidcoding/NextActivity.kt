package com.example.androidcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        val bundle:Bundle? = intent.extras
        val msg = bundle?.get("key_msg")
        val textNext = txt_next
        textNext.text = msg as CharSequence
    }
}
