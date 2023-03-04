package com.example.calculator_iphone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator_iphone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var operand1: Double = 0.0
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Обработка нажатий на кнопки
        binding.button0.setOnClickListener { onNumberButtonClicked("0") }
        binding.button1.setOnClickListener { onNumberButtonClicked("1") }
        binding.button2.setOnClickListener { onNumberButtonClicked("2") }
        binding.button3.setOnClickListener { onNumberButtonClicked("3") }
        binding.button4.setOnClickListener { onNumberButtonClicked("4") }
        binding.button5.setOnClickListener { onNumberButtonClicked("5") }
        binding.button6.setOnClickListener { onNumberButtonClicked("6") }
        binding.button7.setOnClickListener { onNumberButtonClicked("7") }
        binding.button8.setOnClickListener { onNumberButtonClicked("8") }
        binding.button9.setOnClickListener { onNumberButtonClicked("9") }
        binding.buttonDot.setOnClickListener { onNumberButtonClicked(".") }
        binding.buttonPlus.setOnClickListener { onOperatorButtonClicked("+") }
        binding.buttonMinus.setOnClickListener { onOperatorButtonClicked("-") }
        binding.buttonMultiply.setOnClickListener { onOperatorButtonClicked("*") }
        binding.buttonDivide.setOnClickListener { onOperatorButtonClicked("/") }
        binding.buttonEquals.setOnClickListener { onEqualsButtonClicked() }
        binding.buttonClear.setOnClickListener { onClearButtonClicked() }
    }

    private fun onNumberButtonClicked(number: String) {
        // Добавляем цифру или точку в текущее число
        val currentNumber = binding.resultTextView.text.toString()
        binding.resultTextView.text = "$currentNumber$number"
    }

    private fun onOperatorButtonClicked(operator: String) {
        // Сохраняем оператор и текущее число
        operand1 = binding.resultTextView.text.toString().toDouble()
        this.operator = operator
        binding.resultTextView.text = ""
    }

    private fun onEqualsButtonClicked() {
        // Выполняем операцию между operand1 и текущим числом
        val operand2 = binding.result
