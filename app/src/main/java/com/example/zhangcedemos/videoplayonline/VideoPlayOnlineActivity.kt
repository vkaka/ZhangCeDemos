package com.example.zhangcedemos.videoplayonline

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.zhangcedemos.R
import com.example.zhangcedemos.videoplayonline.player.UniversalMediaController
import com.example.zhangcedemos.videoplayonline.player.UniversalVideoView


/**
 * author : zhangce
 * date: on 2023/7/13
 **/
class VideoPlayOnlineActivity : AppCompatActivity(), UniversalVideoView.VideoViewCallback {
    lateinit var mVideoView: UniversalVideoView
    lateinit var mVideoController: UniversalMediaController
    lateinit var mStartBtn: Button

    private val mSeekPosition = 0
    private var cachedHeight = 0
    private val isFullscreen = false

    private val VIDEO_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play_online)
        mVideoView = findViewById(R.id.videoView)
        mVideoController = findViewById(R.id.media_controller)
        mStartBtn = findViewById(R.id.start_play_btn)
        mVideoView.setMediaController(mVideoController)
        setVideoAreaSize()

        mStartBtn.setOnClickListener {
            mVideoView.start()
            mVideoController.setTitle("mydemo")
        }
        mVideoView.setOnCompletionListener {
            Log.e("zhangce", "播放完成")
        }

    }

    /**
     * 置视频区域大小
     */
    private fun setVideoAreaSize() {
        mVideoView.post(Runnable {
            val width: Int = mVideoView.getWidth()
            cachedHeight = (width * 405f / 720f).toInt()
            //                cachedHeight = (int) (width * 3f / 4f);
//                cachedHeight = (int) (width * 9f / 16f);
            val videoLayoutParams: ViewGroup.LayoutParams = mVideoView.getLayoutParams()
            videoLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            videoLayoutParams.height = cachedHeight
            mVideoView.setLayoutParams(videoLayoutParams)
            mVideoView.setVideoPath(VIDEO_URL)
            mVideoView.requestFocus()
        })
    }

    override fun onScaleChange(isFullscreen: Boolean) {
        Log.e("zhangce", "全屏切换")
    }

    override fun onPause(mediaPlayer: MediaPlayer?) {
        Log.e("zhangce", "暂停播放")
    }

    override fun onStart(mediaPlayer: MediaPlayer?) {
        Log.e("zhangce", "开始播放")
    }

    override fun onBufferingStart(mediaPlayer: MediaPlayer?) {
        Log.e("zhangce", "开始缓冲")
    }

    override fun onBufferingEnd(mediaPlayer: MediaPlayer?) {
        Log.e("zhangce", "结束缓冲")
    }
}