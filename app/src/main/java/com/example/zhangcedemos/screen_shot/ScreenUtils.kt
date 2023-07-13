package com.example.zhangcedemos.screen_shot

import android.content.res.Resources

/**
 * author : zhangce
 * date: on 2023/7/13
 **/
object ScreenUtils {
    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    fun getScreenDensityDpi(): Int {
        return Resources.getSystem().displayMetrics.densityDpi
    }
}