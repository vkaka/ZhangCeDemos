package com.example.zhangcedemos.screen_shot

import android.content.Intent
import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.Surface
import android.view.SurfaceView
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.zhangcedemos.R
import com.example.zhangcedemos.screen_shot.ScreenShotActivity.REQUEST_MEDIA_PROJECTION

/**
 * author : zhangce
 * date: on 2023/7/12
 **/
class UseScreenShotActivity : AppCompatActivity() {
    private val REQ_CODE_PER = 0x2304
    private val REQ_CODE_ACT = 0x2305

    private val mediaProjectionManager: MediaProjectionManager by lazy { getSystemService(MEDIA_PROJECTION_SERVICE) as MediaProjectionManager }
    private var mediaProjection: MediaProjection? = null
    private var virtualDisplay: VirtualDisplay? = null
    private lateinit var surfaceView :SurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_srceen_shot)
        surfaceView = findViewById(R.id.surfaceView)
    }

    /**
     * This is an example for using Shooter.
     * This method will request permission and take screenshot on this Activity.
     */
    fun onClickReqPermission(view: View?) {
        startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), REQUEST_MEDIA_PROJECTION)
//        if (Build.VERSION.SDK_INT >= 21) {
//            startActivityForResult(
//                createScreenCaptureIntent(),
//                REQ_CODE_PER
//            )
//        }
    }

    /**
     * using {@see ScreenShotActivity} to take screenshot on current Activity directly.
     * If you press home it will take screenshot on another app.
     * @param view
     */
    fun onClickShot(view: View?) {
        startActivityForResult(
            ScreenShotActivity.createIntent(this, null, 0),
            REQ_CODE_ACT
        )
        toast("Press home key,open another app.") //if you want to take screenshot on another app.
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun createScreenCaptureIntent(): Intent? {
        //Here using media_projection instead of Context.MEDIA_PROJECTION_SERVICE to  make it successfully build on low api.
        return (getSystemService("media_projection") as MediaProjectionManager).createScreenCaptureIntent()
    }

    private fun getSavedPath(): String? {
        return "${getExternalFilesDir("screenshot")!!.absoluteFile}/${SystemClock.currentThreadTimeMillis()}.png"
//        return ( + "/" + SystemClock.currentThreadTimeMillis() + ".png")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_MEDIA_PROJECTION) {
            if (resultCode != RESULT_OK) {
                Log.d("~~~", "User cancelled")
                return
            }
            Log.d("~~~", "Starting screen capture")
            mediaProjection = mediaProjectionManager.getMediaProjection(resultCode, data!!)
            virtualDisplay = mediaProjection!!.createVirtualDisplay(
                "ScreenCapture",
                ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight(), ScreenUtils.getScreenDensityDpi(),
                DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                surfaceView.holder.surface, null, null
            )
        }
//        when (requestCode) {
//            REQ_CODE_ACT -> {
//                if (resultCode == RESULT_OK && data != null) {
//                    toast("Screenshot saved at " + data.data.toString())
//                } else {
//                    toast("You got wrong.")
//                }
//            }
////            REQ_CODE_PER -> {
////                if (resultCode == RESULT_OK && data != null) {
////                    val shooter = Shooter(this@UseScreenShotActivity, resultCode, data)
////                    shooter.startScreenShot(getSavedPath(), object : Shooter.OnShotListener {
////                        //                        fun onFinish(path: String) {
//////                            //here is done status.
//////                            toast("Screenshot saved at $path")
//////                        }
//////
//////                        fun onError() {
//////                            toast("You got wrong.")
//////                        }
////                        override fun onFinish(path: String?) {
////                            toast("Screenshot saved at $path")
////                        }
////
////                        override fun onError() {
////                            toast("You got wrong.")
////                        }
////                    })
////                } else if (resultCode == RESULT_CANCELED) {
////                    //user canceled.
////                } else {
////                }
////            }
//        }
    }


    private fun toast(str: String) {
        Toast.makeText(this@UseScreenShotActivity, str, Toast.LENGTH_LONG).show()
    }

    private fun goBackground() {
        val startMain = Intent(Intent.ACTION_MAIN)
        startMain.addCategory(Intent.CATEGORY_HOME)
        startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(startMain)
    }
}