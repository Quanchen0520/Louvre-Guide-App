package com.example.louvreguideapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 將 activity_main.xml 元件連結至此
        val timeTextView = findViewById<TextView>(R.id.textView_time)
        val Introduce_Btn = findViewById<Button>(R.id.Introduce_Btn)
        val Serve_Btn = findViewById<Button>(R.id.Serve_Btn)

        // 使用Handler動態更新
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                // 取得時間並依設定格式顯示於TextView
                val sdf = SimpleDateFormat("yyyy-MMdd E. mm:ss", Locale.ENGLISH) // 將星期用英文顯示
                val currentTime = sdf.format(Date())
                timeTextView.text = currentTime

                // 刷新時間設定(ms)
                handler.postDelayed(this, 1000)
            }
        }

        handler.post(runnable) // 開始執行

        // 服務Btn點擊判斷
        Serve_Btn.setOnClickListener {
            val intent = Intent(this, ServeActivity::class.java)
            startActivity(intent)
        }

        // 介紹Btn點擊判斷
        Introduce_Btn.setOnClickListener {
            val intent = Intent(this, IntroduceActivity::class.java)
            startActivity(intent)
        }
    }
}