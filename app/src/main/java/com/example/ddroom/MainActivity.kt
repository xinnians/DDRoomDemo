package com.example.ddroom

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        //以外開瀏覽器的方式開啟連結"https://www.dd-room.com/"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dd-room.com/"))
        startActivity(browserIntent)
    }
}