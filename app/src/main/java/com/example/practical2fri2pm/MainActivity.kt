package com.example.practical2fri2pm

import android.content.Context
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.practical2fri2pm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var nicknameText : TextView
//    lateinit var editText : TextView
//    lateinit var doneBtn : Button
    lateinit var binding : ActivityMainBinding
    private var myName2: MyName = MyName("BAIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName1 = myName2
        //myname1 is variable we have in our activity
        //myname2 is binding variable

//        setContentView(R.layout.activity_main)
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
//        nicknameText = findViewById<TextView>(R.id.nickname_edit)
//        editText = findViewById(R.id.nickname_edit)
//        findViewById<Button>(R.id.done_button)
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view:View){

        binding.apply {
            myName1?.nickname = nicknameEdit.text.toString()
            //? = nullable, if var must put
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

//        nicknameText.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameText.visibility = View.VISIBLE

//        // Hide the input line
//        nicknameText.setBackgroundResource(0)

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view : View){
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }

    }
}