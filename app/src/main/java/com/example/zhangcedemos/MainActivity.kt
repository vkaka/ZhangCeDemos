package com.example.zhangcedemos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.zhangcedemos.screen_shot.UseScreenShotActivity
import com.example.zhangcedemos.shopping_cart.ShoppingCartActivity
import com.example.zhangcedemos.videoplayonline.VideoPlayOnlineActivity
import com.example.zhangcedemos.viewpager.MyViewPagerDemo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.screen_shot_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, UseScreenShotActivity::class.java))
        }
        findViewById<Button>(R.id.video_play_online_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, VideoPlayOnlineActivity::class.java))
        }
        findViewById<Button>(R.id.viewpager_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, MyViewPagerDemo::class.java))
        }
        findViewById<Button>(R.id.shopping_cart_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, ShoppingCartActivity::class.java))
        }
    }
}