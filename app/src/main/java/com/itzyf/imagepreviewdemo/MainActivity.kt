package com.itzyf.imagepreviewdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val images = arrayListOf(
        "http://pic1.win4000.com/wallpaper/2018-10-10/5bbd637697588.jpg",
        "http://pic1.win4000.com/wallpaper/2018-10-10/5bbd63758d1ea.jpg",
        "http://pic1.win4000.com/wallpaper/2018-10-10/5bbd6374c4233.jpg",
        "http://pic1.win4000.com/wallpaper/2018-10-10/5bbd6377a63ee.jpg",
        "http://pic1.win4000.com/wallpaper/2018-10-10/5bbd6378a1fdc.jpg",
        "http://pic1.win4000.com/wallpaper/2018-10-10/5bbd6379b2b20.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_look_photo.setOnClickListener {
            val intent = Intent(this, ImagePreviewActivity::class.java)
            intent.putExtra("images", images)
            intent.putExtra("index", 2)
            startActivity(intent)
        }
    }
}
