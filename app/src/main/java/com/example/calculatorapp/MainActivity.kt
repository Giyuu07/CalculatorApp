package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var tvResult: TextView
    private lateinit var tvSolution: TextView
    private var operator = ""
    private var numOfOperator = 0
    private var num1 = ""
    private var num2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Buttons
        //Operators
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val btnModulo = findViewById<Button>(R.id.btnModulo)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnEqual = findViewById<Button>(R.id.btnEqual)

        //Numbers
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnZero = findViewById<Button>(R.id.btnZero)
        val btnDot = findViewById<Button>(R.id.btnDot)

        //Buttons onClick events
        //Operators
        btnClear.setOnClickListener(this)
        btnDelete.setOnClickListener(this)
        btnModulo.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnEqual.setOnClickListener(this)

        //Numbers
        btnNine.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnZero.setOnClickListener(this)
        btnDot.setOnClickListener(this)

    }

    override fun onClick(button: View?) {
        tvSolution = findViewById(R.id.tvSolution)
        tvResult = findViewById(R.id.tvResult)
        val solution = tvSolution.text.toString()
        when(button!!.id){
            R.id.btnNine -> {
                tvSolution.text = tvSolution.text.toString() + "9"
            }
            R.id.btnEight -> {
                tvSolution.text = tvSolution.text.toString() + "8"
            }
            R.id.btnSeven -> {
                tvSolution.text = tvSolution.text.toString() + "7"
            }
            R.id.btnSix -> {
                tvSolution.text = tvSolution.text.toString() + "6"
            }
            R.id.btnFive -> {
                tvSolution.text = tvSolution.text.toString() + "5"
            }
            R.id.btnFour -> {
                tvSolution.text = tvSolution.text.toString() + "4"
            }
            R.id.btnThree -> {
                tvSolution.text = tvSolution.text.toString() + "3"
            }
            R.id.btnTwo -> {
                tvSolution.text = tvSolution.text.toString() + "2"
            }
            R.id.btnOne -> {
                tvSolution.text = tvSolution.text.toString() + "1"
            }
            R.id.btnZero -> {
                tvSolution.text = tvSolution.text.toString() + "0"
            }
            R.id.btnClear -> {
                tvSolution.text = ""
                tvResult.text = ""
                numOfOperator = 0
            }
            R.id.btnDelete -> {
                if(solution.last().isDigit().not()){
                    numOfOperator = 0
                    tvResult.text = ""
                }
                tvSolution.text = solution.dropLast(1)
            }
            R.id.btnModulo -> {
                if (checkLastString(solution)){
                    tvSolution.text = tvSolution.text.toString() + "%"
                }
            }
            R.id.btnDivide -> {
                if (checkLastString(solution) && numOfOperator < 1){
                    tvSolution.text = tvSolution.text.toString() + "/"
                }
            }
            R.id.btnMultiply -> {
                if (checkLastString(solution) && numOfOperator < 1){
                    tvSolution.text = tvSolution.text.toString() + "x"
                }
            }
            R.id.btnMinus -> {
                if (checkLastString(solution) && numOfOperator < 1){
                    tvSolution.text = tvSolution.text.toString() + "-"
                }
            }
            R.id.btnPlus -> {
                if (checkLastString(solution) && numOfOperator < 1){
                    tvSolution.text = tvSolution.text.toString() + "+"
                }
            }
            R.id.btnDot -> {
                if (checkLastString(solution)){
                    tvSolution.text = tvSolution.text.toString() + "."
                }
            }
            R.id.btnEqual -> {

                if(!solution.isNullOrEmpty() && checkOperator(solution)){
                    var s = solution.split("+", "-", "x", "/", "%")
                    num1 = s[0]
                    num2 = s[1]
                    val res = getResult(num1.toFloat(), num2.toFloat(), operator)
                    tvResult.text = "= $res"
                }
            }
        }
    }

    private fun getResult(num1 : Float, num2 : Float, op : String) : Float{
        return when {
            op.equals("+") -> num1 + num2
            op.equals("-") -> num1 - num2
            op.equals("/") -> num1 / num2
            op.equals("x") -> num1 * num2
            else -> num1 % num2
        }
    }
    private fun checkLastString(s : String?) : Boolean{
        if(s!!.last().isDigit()){
            return true
        }
        return false
    }

    private fun checkOperator(s : String?) : Boolean{
        var hasOperator = false
        val operators = charArrayOf('+', '-', '/', '%', 'x')
        s!!.forEach {
            if(it in operators){
                hasOperator = true
                numOfOperator++
                operator = it.toString()
            }
        }
        return hasOperator
    }


}