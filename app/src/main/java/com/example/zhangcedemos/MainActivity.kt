package com.example.zhangcedemos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.zhangcedemos.charts.ChartsDemoActivity
import com.example.zhangcedemos.screen_shot.UseScreenShotActivity
import com.example.zhangcedemos.select_city.SelectCity2Activity
import com.example.zhangcedemos.shopping_cart.ShoppingCartActivity
import com.example.zhangcedemos.svg_demo.SvgDemoActivity
import com.example.zhangcedemos.upan_demo.UpanDemoActivity
import com.example.zhangcedemos.videoplayonline.VideoPlayOnlineActivity
import com.example.zhangcedemos.viewpager.MyViewPagerDemo
import com.example.zhangcedemos.xiecheng.XieChengActivity

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
        findViewById<Button>(R.id.xie_cheng_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, XieChengActivity::class.java))
        }
        findViewById<Button>(R.id.svg_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, SvgDemoActivity::class.java))
        }
        findViewById<Button>(R.id.charts_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, ChartsDemoActivity::class.java))
        }
        findViewById<Button>(R.id.upan_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, UpanDemoActivity::class.java))
        }

        findViewById<Button>(R.id.city_list_btn).setOnClickListener {
            startActivity(Intent(this@MainActivity, SelectCity2Activity::class.java))
        }
    }
}