package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.util.zip.Inflater

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button0.setOnClickListener(this)
        binding.buttonDot.setOnClickListener(this)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.buttonEquals.setOnClickListener(this)
        binding.buttonPlus.setOnClickListener(this)
        binding.buttonLess.setOnClickListener(this)
        binding.buttonMultiplication.setOnClickListener(this)
        binding.buttonDivision.setOnClickListener(this)
        binding.buttonCloseParentheses.setOnClickListener(this)
        binding.buttonOpenParentheses.setOnClickListener(this)
        binding.buttonDelete.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val textNumbers = binding.textViewNumberToCalculate

        when (view.id) {
            R.id.button_0 -> textNumbers.text = "${textNumbers.text}0"
            R.id.button_1 -> textNumbers.text = "${textNumbers.text}1"
            R.id.button_2 -> textNumbers.text = "${textNumbers.text}2"
            R.id.button_3 -> textNumbers.text = "${textNumbers.text}3"
            R.id.button_4 -> textNumbers.text = "${textNumbers.text}4"
            R.id.button_5 -> textNumbers.text = "${textNumbers.text}5"
            R.id.button_6 -> textNumbers.text = "${textNumbers.text}6"
            R.id.button_7 -> textNumbers.text = "${textNumbers.text}7"
            R.id.button_8 -> textNumbers.text = "${textNumbers.text}8"
            R.id.button_9 -> textNumbers.text = "${textNumbers.text}9"
            R.id.button_dot -> textNumbers.text = "${textNumbers.text}."
            R.id.button_equals -> {
                binding.buttonEquals.setOnClickListener {
                    val resultado = Expression(textNumbers.text.toString()).calculate()
                    if (resultado.isNaN()) {
                        val toast = Toast.makeText(
                            this, "Insira uma expressão matemática", Toast.LENGTH_SHORT
                        )
                        toast.show()
                    } else {
                        binding.textViewNumberToCalculate.text = resultado.toString()

                    }

                }
            }

            R.id.button_plus -> textNumbers.text = "${textNumbers.text}+"
            R.id.button_less -> textNumbers.text = "${textNumbers.text}-"
            R.id.button_multiplication -> textNumbers.text = "${textNumbers.text}*"
            R.id.button_division -> textNumbers.text = "${textNumbers.text}/"
            R.id.button_close_parentheses -> textNumbers.text = "${textNumbers.text})"
            R.id.button_open_parentheses -> textNumbers.text = "${textNumbers.text}("
            R.id.button_delete -> {
                binding.buttonDelete.setOnClickListener {
                    textNumbers.text = textNumbers.text.dropLast(1)
                }
            }
        }
    }
}