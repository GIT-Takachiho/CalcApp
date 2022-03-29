package jp.techacademy.takaomi.okabe.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
// import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        var str1 = editText1.text.toString()
        var str2 = editText2.text.toString()
        var num1 : Double
        var num2 : Double
        var answer : Double = 0.0

        if((str1 != "") && (str2 != "")) {
            val intent = Intent(this, SecondActivity::class.java)
            num1 = editText1.text.toString().toDouble()
            num2 = editText2.text.toString().toDouble()

            when(v.id){
                R.id.button1 -> answer = num1 + num2
                R.id.button2 -> answer = num1 - num2
                R.id.button3 -> answer = num1 * num2
                R.id.button4 -> answer = num1 / num2
            }

            intent.putExtra("VALUE", answer)
            startActivity(intent)
        }else{
            textView.text = "数値を入力してください"
        }
    }
}