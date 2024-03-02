package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder



class MainActivity : AppCompatActivity() {
    lateinit var tvResult:TextView
    lateinit var tvExpression:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //

        tvResult=findViewById(R.id.tvResult)
        tvExpression=findViewById(R.id.tvExpression)
        val tvOne:TextView=findViewById(R.id.tvOne)
        val tvTwo:TextView=findViewById(R.id.tvTwo)
        val tvThree:TextView=findViewById(R.id.tvThree)
        val tvFour:TextView=findViewById(R.id.tvFour)
        val tvFive:TextView=findViewById(R.id.tvFive)
        val tvSix:TextView=findViewById(R.id.tvSix)
        val tvSeven:TextView=findViewById(R.id.tvSeven)
        val tvEight:TextView=findViewById(R.id.tvEight)
        val tvNine:TextView=findViewById(R.id.tvNine)
        val tvZero:TextView=findViewById(R.id.tvZero)
        val tvDot:TextView=findViewById(R.id.tvDot)
        val tvPlus:TextView=findViewById(R.id.tvPlus)
        val tvMinus:TextView=findViewById(R.id.tvMinus)
        val tvMul:TextView=findViewById(R.id.tvMul)
        val tvDivide:TextView=findViewById(R.id.tvDivide)
        val tvOpen:TextView=findViewById(R.id.tvOpen)
        val tvClose:TextView=findViewById(R.id.tvClose)
        val tvClear:TextView=findViewById(R.id.tvClear)
        val tvEquals:TextView=findViewById(R.id.tvEquals)
        val tvback:TextView=findViewById(R.id.tvBack)

        //Numbers
        tvOne.setOnClickListener { appendOnExpression("1",true) }
        tvTwo.setOnClickListener { appendOnExpression("2",true) }
        tvThree.setOnClickListener { appendOnExpression("3",true) }
        tvFour.setOnClickListener { appendOnExpression("4",true) }
        tvFive.setOnClickListener { appendOnExpression("5",true) }
        tvSix.setOnClickListener { appendOnExpression("6",true) }
        tvSeven.setOnClickListener { appendOnExpression("7",true) }
        tvEight.setOnClickListener { appendOnExpression("8",true) }
        tvNine.setOnClickListener { appendOnExpression("9",true) }
        tvZero.setOnClickListener { appendOnExpression("0",true) }
        tvDot.setOnClickListener { appendOnExpression(".",true) }

        //Operators
        tvPlus.setOnClickListener { appendOnExpression("+",false) }
        tvMinus.setOnClickListener { appendOnExpression("-",false) }
        tvMul.setOnClickListener { appendOnExpression("*",false) }
        tvDivide.setOnClickListener { appendOnExpression("/",false) }
        tvOpen.setOnClickListener { appendOnExpression("(",false) }
        tvClose.setOnClickListener { appendOnExpression(")",false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
        tvback.setOnClickListener{
            if(tvExpression.text.isNotEmpty()){
               // tvExpression.text=tvExpression.text.substring(0,(tvExpression.text.toString().length)-1)
                val new=tvExpression.text.dropLast(1)
                tvExpression.text=new
            }
        }

        tvEquals.setOnClickListener {
            try{


                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longresult=result.toLong()

            if(result==longresult.toDouble()){
                tvResult.text=longresult.toString()
            }
            else
                tvResult.text=result.toString()
            }catch (e:Exception){
                Log.d("Exception","Message:"+e.message)
            }

        }

    }

    private fun appendOnExpression(string: String,canClear:Boolean) {

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}
