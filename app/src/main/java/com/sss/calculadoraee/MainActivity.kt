package com.sss.calculadoraee

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtCaja: EditText
    private var operador: String = ""
    private var num1: String = ""
    private var num2: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCaja = findViewById(R.id.txtcaja)
    }

    fun bt1(view: View) {
        txtCaja.append("1")
    }

    fun bt2(view: View) {
        txtCaja.append("2")
    }

    fun bt3(view: View) {
        txtCaja.append("3")
    }

    fun bt4(view: View) {
        txtCaja.append("4")
    }

    fun bt5(view: View) {
        txtCaja.append("5")
    }

    fun bt6(view: View) {
        txtCaja.append("6")
    }

    fun bt7(view: View) {
        txtCaja.append("7")
    }

    fun bt8(view: View) {
        txtCaja.append("8")
    }

    fun bt9(view: View) {
        txtCaja.append("9")
    }

    fun bt0(view: View) {
        txtCaja.append("0")
    }

    fun suma(view: View) {
        num1 = txtCaja.text.toString()
        txtCaja.setText("")
        operador = "+"
    }

    fun resta(view: View) {
        num1 = txtCaja.text.toString()
        txtCaja.setText("")
        operador = "-"
    }

    fun multiplicacion(view: View) {
        num1 = txtCaja.text.toString()
        txtCaja.setText("")
        operador = "*"
    }

    fun division(view: View) {
        num1 = txtCaja.text.toString()
        txtCaja.setText("")
        operador = "/"
    }

    fun igual(view: View) {
        num2 = txtCaja.text.toString()
        var resultado = 0.0
        when (operador) {
            "+" -> resultado = num1.toDouble() + num2.toDouble()
            "-" -> resultado = num1.toDouble() - num2.toDouble()
            "*" -> resultado = num1.toDouble() * num2.toDouble()
            "/" -> resultado = num1.toDouble() / num2.toDouble()
        }
        txtCaja.setText(resultado.toString())
    }

    fun borrar(view: View) {
        var cadena = txtCaja.text.toString()
        if (cadena.isNotEmpty()) {
            cadena = cadena.substring(0, cadena.length - 1)
            txtCaja.setText(cadena)
        }
    }

    fun clear(view: View) {
        txtCaja.setText("")
    }
}
