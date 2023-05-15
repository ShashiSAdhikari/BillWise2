package com.example.billwise

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.billwise.models.Calculator

class Cal : Fragment() {
//Declare variables
    private lateinit var edtNumber1: EditText
    private lateinit var edtNumber2: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cal, container, false)

        //get numbers inputs
        edtNumber1 = view.findViewById(R.id.et_num1)
        edtNumber2 = view.findViewById(R.id.et_num2)

        // get assign details into button
        val buttonPlus: Button = view.findViewById(R.id.btn_plus)
        val buttonMinus: Button = view.findViewById(R.id.btn_minus)
        val buttonMultiply: Button = view.findViewById(R.id.btn_multiply)
        val buttonDivide: Button = view.findViewById(R.id.btn_divide)

        //create functions
        buttonPlus.setOnClickListener {
            calculateResult(it, "+")
        }

        buttonMinus.setOnClickListener {
            calculateResult(it, "-")
        }

        buttonMultiply.setOnClickListener {
            calculateResult(it, "*")
        }

        buttonDivide.setOnClickListener {
            calculateResult(it, "/")
        }

        return view
    }

    //calculate result
    private fun calculateResult(view: View, operator: String) {
        val calculator = Calculator(
            edtNumber1.text.toString().toDouble(),
            edtNumber2.text.toString().toDouble()
        )
        //operations
        val ans = when(operator) {
            "+" -> calculator.add()
            "-" -> calculator.subtract()
            "*" -> calculator.multiply()
            "/" -> calculator.divide()
            else -> 0.0
        }
        //print answer
        println(ans)
        //Riderect into ResultActivity
        val intent = Intent(activity, ResultActivity::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
    }
}
