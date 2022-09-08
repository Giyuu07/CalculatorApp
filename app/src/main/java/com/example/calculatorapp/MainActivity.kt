package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var etNum1 : EditText
    private lateinit var etNum2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    private fun validateInput(num1 : String?, num2: String?) : Boolean {
        return when {
            num1.isNullOrEmpty() || num2.isNullOrEmpty() -> {
                Toast.makeText(this, "Please input 2 numbers to proceed!", Toast.LENGTH_SHORT).show()
                false
            }else -> true
        }
    }

    private fun getResult(num1 : String?, num2: String?, op : String) : Float{
        var sum = when(op){
            "+" -> num1!!.toFloat() + num2!!.toFloat()
            else -> 0f
        }
        return sum
    }

    private fun clearInputs(){
        etNum1.setText("")
        etNum2.setText("")
    }
}