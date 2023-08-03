package com.example.zhangcedemos.viewpager

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.zhangcedemos.R
import com.example.zhangcedemos.viewpager.banner.BannerAdapter
import com.example.zhangcedemos.viewpager.banner.ScaleTransformer
import java.util.*

/**
 * author : zhangce
 * date: on 2023/8/3
 **/
class MyViewPagerDemo : AppCompatActivity() {
    private lateinit var viewpager: ViewPager

    private val mDrawables = intArrayOf(
        R.mipmap.guidao_d,
        R.mipmap.guidao_c,
        R.mipmap.guidao_b,
        R.mipmap.guidao_a
    )

    var mHotColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager_demo)

        initView()
        initListener()
        initData()

    }

    private fun initView() {
        viewpager = findViewById(R.id.demo_vp)
        val viewPagerRootView = findViewById<RelativeLayout>(R.id.viewPagerRootView)


        //未封装Banner
        initBannerViewPager(viewpager, viewPagerRootView)
    }

    private fun initListener() {

    }

    private fun initData() {
    }

    private fun initBannerViewPager(viewPager: ViewPager, viewPagerRootView: RelativeLayout) {
        val timer = Timer()

        //设置适配器
        viewPager.adapter = BannerAdapter(this, mDrawables)

        //Pager之间的间距
        viewPager.pageMargin = 20

        //预加载
        viewPager.offscreenPageLimit = 5

        //设置两边小 中间大 【切记配合 xml: android:clipChildren="false" 参数使用】
        //图书
        viewPager.setPageTransformer(true, ScaleTransformer())

        //默认第一张图 左右都有图
        viewPager.currentItem = 1

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                val drawable: Int = mDrawables.get(position % mDrawables.size)
                val bitmap = BitmapFactory.decodeResource(resources, drawable)
                ColorUtil.getInstance().initPalette(bitmap, object : ColorUtil.onColorUtilClick {
                    override fun bitmapColors(
                        hotColor: Int,
                        darkMutedColor: Int,
                        lightMutedColor: Int,
                        darkVibrantColor: Int,
                        lightVibrantColor: Int,
                        mutedColor: Int,
                        vibrantColor: Int
                    ) {
                        Log.i("szjHotColor2", hotColor.toString() + "")
                        //普通设置颜色
                        //circleRelateLayout.setBackgroundColor(hotColor);

                        //设置渐变颜色
//                        int[] color = new int[]{mutedColor, lightVibrantColor, vibrantColor};
//                        ColorUtil.getInstance().setGradualChange(circleRelateLayout, color, GradientDrawable.Orientation.TL_BR, 0);

                        //动画设置背景颜色
                        ColorUtil.getInstance()
                            .setAnimatorColor(viewPagerRootView, 1000, mHotColor, hotColor)
                        mHotColor = hotColor
                    }
                })
            }

            override fun onPageScrollStateChanged(state: Int) {
//                isDown = false
            }
        })

        //viewPager左右两边滑动无效的处理
//        viewPagerRootView.setOnTouchListener((v, event) -> viewPager.onTouchEvent(event));
    }

}
