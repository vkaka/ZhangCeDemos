package com.example.zhangcedemos.upan_demo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * author : zhangce
 * date: on 2024/6/6
 **/
class USBDiskReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var act = intent?.action;
        var pat = intent?.data?.path
        if (!pat.isNullOrEmpty()) {
            if ("android.intent.action.MEDIA_MOUNTED".equals(act)) {
                Log.e("zhang", "U盘路径----" + pat);
            }
            if ("android.intent.action.MEDIA_REMOVED".equals(act)) {
                Log.e("zhang", "U盘拨出----");
            }
        }
    }
}