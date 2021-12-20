package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import java.util.Arrays.toString
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException
import kotlin.Unit.toString
import kotlin.coroutines.EmptyCoroutineContext.toString

class MainActivity : AppCompatActivity() {

    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonPercent: android.widget.Button
    lateinit var buttonCleared: android.widget.Button
    lateinit var buttonDot: android.widget.Button
    lateinit var buttonEqual: android.widget.Button
    lateinit var buttonAdd: android.widget.Button
    lateinit var buttonSub: android.widget.Button
    lateinit var buttonMul: android.widget.Button
    lateinit var buttonDivide: android.widget.Button
    lateinit var buttonBackspace: android.widget.Button

    lateinit var inputtex: EditText
    lateinit var resulttex: EditText

    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0 = findViewById(R.id.button0)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button00 = findViewById(R.id.button00)
        buttonPercent = findViewById(R.id.buttonPercent)
        buttonCleared = findViewById(R.id.buttonCleared)
        buttonDot = findViewById(R.id.buttonDot)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSub = findViewById(R.id.buttonSub)
        buttonMul = findViewById(R.id.buttonMultiple)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonBackspace = findViewById(R.id.buttonBackspace)
        resulttex = findViewById(R.id.result)
        inputtex = findViewById(R.id.input)
        inputtex.movementMethod = ScrollingMovementMethod()
        inputtex.setActivated(true)
        inputtex.setPressed(true)


        var text: String



        button1.setOnClickListener {
            text = inputtex.text.toString() + "1"
            inputtex.setText(text)
            result(text)
        }

        button2.setOnClickListener {
            text = inputtex.text.toString() + "2"
            inputtex.setText(text)
            result(text)
        }

        button3.setOnClickListener {
            text = inputtex.text.toString() + "3"
            inputtex.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text = inputtex.text.toString() + "5"
            inputtex.setText(text)
            result(text)
        }
        button6.setOnClickListener {
            text = inputtex.text.toString() + "6"
            inputtex.setText(text)
            result(text)
        }
        button7.setOnClickListener {
            text = inputtex.text.toString() + "7"
            inputtex.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text = inputtex.text.toString() + "8"
            inputtex.setText(text)
            result(text)
        }
        button9.setOnClickListener {
            text = inputtex.text.toString() + "9"
            inputtex.setText(text)
            result(text)
        }
        button0.setOnClickListener {
            text = inputtex.text.toString() + "0"
            inputtex.setText(text)
            result(text)
        }
        buttonDot.setOnClickListener {
            text = inputtex.text.toString() + "."
            inputtex.setText(text)
            result(text)
        }


        buttonAdd.setOnClickListener {
            text = inputtex.text.toString() + "+"
            inputtex.setText(text)
            check = check + 1
        }

        buttonSub.setOnClickListener {
            text = inputtex.text.toString() + "-"
            inputtex.setText(text)
            check = check + 1
        }
        buttonMul.setOnClickListener {
            text = inputtex.text.toString() + "*"
            inputtex.setText(text)
            check = check + 1
        }
        buttonDivide.setOnClickListener {
            text = inputtex.text.toString() + "/"
            inputtex.setText(text)
            check = check + 1
        }

        buttonPercent.setOnClickListener {
            text = inputtex.text.toString() + "%"
            inputtex.setText(text)
            check = check + 1
        }

        buttonEqual.setOnClickListener {
            text = resulttex.text.toString()
            inputtex.setText(text)
            resulttex.setText(null)
        }

        buttonCleared.setOnClickListener {
            inputtex.setText(null)
            resulttex.setText(null)
        }
        buttonBackspace.setOnClickListener {
            var backSpace: String? = null
            if (inputtex.text.isNotEmpty()) {
                val stringBuilder: StringBuilder = StringBuilder(inputtex.text)
                val find = inputtex.text.toString()
                val find2 = find.last()

                if (find2 == '+' || find2 == '-' || find2 == '*' || find2 == '/' || find2 == '%'
                ) {
                    check -= 1
                }
                with(stringBuilder) {

                    if (find2 == '+' || find2 == '-' || find2 == '*' || find2 == '/' || find2 == '%'
                    ) {
                        check -= 1
                    }
                    val deleteCharAt = deleteCharAt(inputtex.text.length - 1)
                    backSpace = stringBuilder.toString()
                    inputtex.setText(backSpace)
                    backSpace?.let { it1 -> result(it1) }
                }


            }


        }
    }

    private fun result(it1: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("Nahid")
        try {
            val result: Any = engine.eval(it1)
            var main = result.toString()
            if (check == 0) {
                resulttex.setText(null)
            } else {
                resulttex.setText(main)
            }

        }
        catch(e: ScriptException) {
            Log.d("TAG", "ERROR")
        }
    }
}


//tomar ei function e value name it1
//eiber ora jeivabe krse kore dekho hoye jabe, function create e prb chilo tomar e
// ok kore dekhi na hole eita niye rate ektu smy diyo first to last bujhe nibone ?
//accha thik ase