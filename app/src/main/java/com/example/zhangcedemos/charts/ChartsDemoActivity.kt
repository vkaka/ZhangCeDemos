package com.example.zhangcedemos.charts

import android.animation.Animator
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
import com.bumptech.glide.Glide
import com.example.zhangcedemos.R
import lecho.lib.hellocharts.gesture.ContainerScrollType
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.Line
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PointValue
import lecho.lib.hellocharts.view.LineChartView
import java.util.Collections

/**
 * author : zhangce
 * date: on 2024/5/30
 **/
class ChartsDemoActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charts_demo)

        var chart = findViewById<LineChartView>(R.id.chart)

        var data = LineChartData()
        data.axisXBottom = Axis()
        data.axisYLeft = Axis()

        var values = mutableListOf<PointValue>()
        var line = Line(values).setColor(Color.BLUE)
        data.setLines(Collections.singletonList(line))

        chart.lineChartData = data

        chart.isZoomEnabled = true
        chart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL)

    }
}