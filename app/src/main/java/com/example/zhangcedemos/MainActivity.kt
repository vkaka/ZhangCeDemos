package com.example.zhangcedemos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.zhangcedemos.screen_shot.UseScreenShotActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.screen_shot_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, UseScreenShotActivity::class.java))
        }
    }
}