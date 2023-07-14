package com.example.practical2fri2pm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var doneBtn : Button
    lateinit var nicknameText : TextView
    lateinit var editText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doneBtn = findViewById<Button>(R.id.done_button)
        nicknameText = findViewById<TextView>(R.id.nickname_edit)
        editText = findViewById(R.id.nickname_edit)
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view:View){

        nicknameText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        // Hide the input line
        nicknameText.setBackgroundResource(0)

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view : View){
        editText.visibility = View.VISIBLE
        doneBtn.visibility = View.VISIBLE
        view.visibility = View.GONE

    }
}