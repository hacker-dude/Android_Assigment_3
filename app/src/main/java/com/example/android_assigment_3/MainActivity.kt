package com.example.android_assigment_3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private lateinit var input: TextView
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button
    private lateinit var btnPoint: Button
    private lateinit var btncalculate: Button
    private lateinit var btnClear: Button

    private var firstNumber = 0.0
    private var secondNumber = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        input = findViewById(R.id.input)

        btn0 =
            findViewById<Button?>(R.id.zero).also { it.setOnClickListener { appendText(it as Button) } }
        btn1 =
            findViewById<Button?>(R.id.one).also { it.setOnClickListener { appendText(it as Button) } }
        btn2 =
            findViewById<Button?>(R.id.two).also { it.setOnClickListener { appendText(it as Button) } }
        btn3 =
            findViewById<Button?>(R.id.three).also { it.setOnClickListener { appendText(it as Button) } }
        btn4 =
            findViewById<Button?>(R.id.four).also { it.setOnClickListener { appendText(it as Button) } }
        btn5 =
            findViewById<Button?>(R.id.five).also { it.setOnClickListener { appendText(it as Button) } }
        btn6 =
            findViewById<Button?>(R.id.six).also { it.setOnClickListener { appendText(it as Button) } }
        btn7 =
            findViewById<Button?>(R.id.seven).also { it.setOnClickListener { appendText(it as Button) } }
        btn8 =
            findViewById<Button?>(R.id.eight).also { it.setOnClickListener { appendText(it as Button) } }
        btn9 =
            findViewById<Button?>(R.id.nine).also { it.setOnClickListener { appendText(it as Button) } }

        btnAdd =
            findViewById<Button?>(R.id.add).also { it.setOnClickListener { addOperation(it as Button) } }
        btnSub =
            findViewById<Button?>(R.id.subtract).also { it.setOnClickListener { addOperation(it as Button) } }
        btnMul =
            findViewById<Button?>(R.id.multiply).also { it.setOnClickListener { addOperation(it as Button) } }
        btnDiv =
            findViewById<Button?>(R.id.divide).also { it.setOnClickListener { addOperation(it as Button) } }
        btnPoint =
            findViewById<Button?>(R.id.point).also { it.setOnClickListener { appendText(it as Button) } }
        btncalculate =
            findViewById<Button?>(R.id.calculate).also { it.setOnClickListener { calculate() } }
        btnClear = findViewById(R.id.clear)

        btnClear.setOnClickListener { remLast() }
        btnClear.setOnLongClickListener {
            reset()
            true
        }


    }

    private fun reset() {
        input.text = ""
        firstNumber = 0.0
        secondNumber = 0.0
        operation = ""
    }

    private fun remLast() {
        input.text = input.text.toString().dropLast(1)
    }

    private fun appendText(button: Button) {
        if (button.text.equals("0") && input.text.startsWith("0")) return
        if (button.text.equals(".") && input.text.contains(".")) return

        val update = input.text.toString() + button.text.toString()
        input.text = update
    }

    private fun addOperation(button: Button) {
        firstNumber = input.text.toString().toDouble()
        operation = button.text.toString()
        input.text = ""
    }

    private fun calculate() {
        var result = 0.0
        val inputText = input.text.toString()
        if (inputText == "") {
            firstNumber = 0.0
            return
        }

        secondNumber = inputText.toDouble()

        when (operation) {
            "+" -> result = firstNumber + secondNumber
            "-" -> result = firstNumber - secondNumber
            "*" -> result = firstNumber * secondNumber
            "/" -> result = firstNumber / secondNumber
        }

        val format = DecimalFormat("0.#")
        input.text = format.format(result).toString()
        firstNumber = 0.0
    }
}