package com.example.karag.mysecondproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {


    var string :String = ""
    var a = emptyArray<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Numbers
        tvOne.setOnClickListener{appendOnExpression("1",true)}
        tvTwo.setOnClickListener{appendOnExpression("2",true)}
        tvThree.setOnClickListener{appendOnExpression("3",true)}
        tvFour.setOnClickListener{appendOnExpression("4",true)}
        tvFive.setOnClickListener{appendOnExpression("5",true)}
        tvSix.setOnClickListener{appendOnExpression("6",true)}
        tvSeven.setOnClickListener{appendOnExpression("7",true)}
        tvEight.setOnClickListener{appendOnExpression("8",true)}
        tvNine.setOnClickListener{appendOnExpression("9",true)}
        tvDot.setOnClickListener{appendOnExpression(".",true)}
        //Operators
        tvPlus.setOnClickListener{appendOnExpression("+",true)}
        tvMinus.setOnClickListener{appendOnExpression("-",true)}
        tvDivide.setOnClickListener{appendOnExpression("/",true)}
        tvMul.setOnClickListener{appendOnExpression("*",true)}
        tvOpen.setOnClickListener{appendOnExpression("(",true)}
        tvClose.setOnClickListener{appendOnExpression(")",true)}

        tvClear.setOnClickListener{
            tvExpression.text =""
            tvResult.text = ""
        }

        tvBack.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }
        tvEquals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble()){
                    tvResult.text = longResult.toString()
//                    str += result.toString()
//                    tvHistory.text
                    }
                else
                    tvResult.text = result.toString()
                    string += longResult.toString() + ", "
                    tvHistory.text = string

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }
        deleteHistory.setOnClickListener{string = ""; tvHistory.text = string}
    }
    //


    fun appendOnExpression(string:String, canClear : Boolean){
        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }
        if(canClear){
            tvResult.text =""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}
