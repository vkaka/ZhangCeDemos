package com.example.zhangcedemos.svg_demo

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
import com.bumptech.glide.Glide
import com.example.zhangcedemos.R

/**
 * author : zhangce
 * date: on 2024/5/30
 **/
class SvgDemoActivity :AppCompatActivity() {
    lateinit var rainView: ImageView
    lateinit var lottieView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_svg_demo)

        rainView = findViewById(R.id.svg_iv)
        lottieView = findViewById(R.id.lottie_view)

        Glide.with(this).load(R.drawable.rain).into(rainView)

        rainView.setOnClickListener {
            lottieView.playAnimation()
        }
        lottieView.addAnimatorListener(object : AnimationListener, Animator.AnimatorListener {

            override fun onAnimationStart(animation: Animator) {
                Log.e("zhang", "开始播放动画")
            }

            override fun onAnimationEnd(animation: Animator) {
                Log.e("zhang", "停止播放动画")
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

            override fun onValueChanged() {
            }

        })
    }
}