package com.sss.calculadoraee

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sss.calculadoraee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var operador: String = ""
    private var num1: String = ""
    private var num2: String = ""
    private lateinit var txtcaja: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttons = arrayOf(
            binding.btnuno, binding.btndos, binding.btntres, binding.btncua,
            binding.btncinco, binding.btnseis, binding.btnsie, binding.btnoch,
            binding.btnnue, binding.cero, binding.btnMas, binding.btnmenos,
            binding.btnMult, binding.btndiv, binding.btnigual, binding.btnElimNum,
            binding.btnElimTodo
        )

        buttons.forEach { button ->
            button.setOnClickListener(this)
        }
        txtcaja = binding.txtcaja
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cero -> appendNumber("0")
            R.id.btnuno -> appendNumber("1")
            R.id.btndos -> appendNumber("2")
            R.id.btntres -> appendNumber("3")
            R.id.btncua -> appendNumber("4")
            R.id.btncinco -> appendNumber("5")
            R.id.btnseis -> appendNumber("6")
            R.id.btnsie -> appendNumber("7")
            R.id.btnoch -> appendNumber("8")
            R.id.btnnue -> appendNumber("9")
            R.id.btnMas -> setOperator("+")
            R.id.btnmenos -> setOperator("-")
            R.id.btnMult -> setOperator("*")
            R.id.btndiv -> setOperator("/")
            R.id.btnigual -> calculateResult()
            R.id.btnElimNum -> borrar (V)
            R.id.btnElimTodo -> clear(V)

        }
    }
    private fun appendNumber(number: String) {
        binding.txtcaja.append(number)
    }
    private fun setOperator(operator: String) {
        num1 = binding.txtcaja.text.toString()
        binding.txtcaja.setText("")
        this.operador = operator
    }
    private fun calculateResult() {
        num2 = binding.txtcaja.text.toString()
        var resultado = 0.0
        when (operador) {
            "+" -> resultado = num1.toDouble() + num2.toDouble()
            "-" -> resultado = num1.toDouble() - num2.toDouble()
            "*" -> resultado = num1.toDouble() * num2.toDouble()
            "/" -> resultado = num1.toDouble() / num2.toDouble()
        }
        binding.txtcaja.setText(resultado.toString())
    }
    fun borrar(view: Int) {
        var cadena = txtcaja.text.toString()
        if (cadena.isNotEmpty()) {
            cadena = cadena.substring(0, cadena.length - 1)
            txtcaja.setText(cadena)
        }
    }
    fun clear(view: Int) {
        txtcaja.setText("")
    }
}