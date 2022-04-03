package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var bc: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bc.root)

        bc.b0.setOnClickListener { setTestFields("0") }
        bc.b1.setOnClickListener { setTestFields("1") }
        bc.b2.setOnClickListener { setTestFields("2") }
        bc.b3.setOnClickListener { setTestFields("3") }
        bc.b4.setOnClickListener { setTestFields("4") }
        bc.b5.setOnClickListener { setTestFields("5") }
        bc.b6.setOnClickListener { setTestFields("6") }
        bc.b7.setOnClickListener { setTestFields("7") }
        bc.b8.setOnClickListener { setTestFields("8") }
        bc.b9.setOnClickListener { setTestFields("9") }
        bc.bmin.setOnClickListener { setTestFields("-") }
        bc.bplus.setOnClickListener { setTestFields("+") }
        bc.bmn.setOnClickListener { setTestFields("*") }
        bc.bdil.setOnClickListener { setTestFields("/") }
        bc.bld.setOnClickListener { setTestFields("(") }
        bc.brd.setOnClickListener { setTestFields(")") }
        bc.bkrapka.setOnClickListener { setTestFields(".") }
        bc.bac.setOnClickListener {
            bc.mathOperation.text = ""
            bc.resultText.text = ""
        }
        bc.bback.setOnClickListener {
            val str = bc.mathOperation.text.toString()
            if (str.isNotEmpty()) bc.mathOperation.text = str.substring(0, str.length-1)
            bc.resultText.text = ""
        }
        bc.bequal.setOnClickListener {
            try{
                val ex = ExpressionBuilder(bc.mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    bc.resultText.text = longRes.toString()
                else bc.resultText.text = result.toString()

            }catch (e:Exception){
                Log.d("MyLog", "Сообщение: ${e.message}")
            }
        }


    }

    fun setTestFields(str: String){
        if(bc.resultText.text != ""){
            bc.mathOperation.text = bc.resultText.text
            bc.resultText.text = ""
        }
        bc.mathOperation.append(str)
    }





}