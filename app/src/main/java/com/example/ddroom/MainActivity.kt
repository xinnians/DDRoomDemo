package com.example.ddroom

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pl.droidsonroids.gif.GifDrawable





class MainActivity : AppCompatActivity() {

    //欲連結網址
    private val mUri = Uri.parse("https://www.dd-room.com/")
    //欲停留時間
    private val mWaitTime = 3000L
    //timer object
    private var mTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGifLogo()
    }

    override fun onResume() {
        super.onResume()
        startTimer(mWaitTime)
    }

    override fun onPause() {
        super.onPause()
        stopTimer()
    }

    //啟動timer
    private fun startTimer(waitTime: Long) {
        mTimer = object : CountDownTimer(waitTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                openBrowser(mUri)
            }
        }
        (mTimer as CountDownTimer).start()
    }

    //停止timer
    private fun stopTimer() {
        mTimer?.cancel()
    }

    //以外開瀏覽器的方式開啟連結uri
    private fun openBrowser(uri: Uri) {
        val browserIntent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(browserIntent)
    }

    //設定啟動頁的gif logo
    private fun initGifLogo() {
        // sample.gif 為使用的gif名稱，存取在assets的資料夾內
        val gifFromAssets = GifDrawable(assets, "sample.gif")
        ivGif.setImageDrawable(gifFromAssets)
    }
}