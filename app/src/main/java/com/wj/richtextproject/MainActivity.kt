package com.wj.richtextproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.wj.audioproject.utils.GlideApp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val html = """
  <p style="text-align: center; "><span style="font-size: 18px; background-color: rgb(255, 255, 255); color: rgb(255, 0, 0); font-weight: bold; font-style: italic;">任务描述</span></p>
  <p style="text-align: left;"><span style="font-size: 18px; background-color: rgb(255, 255, 255); color: rgb(255, 0, 0); font-weight: bold; font-style: italic;">任务描述任务描述</span></p>
  <p style="text-align: right;"><span style="font-size: 18px; background-color: rgb(255, 255, 255); color: rgb(255, 0, 0); font-weight: bold; font-style: italic;">任务描述任务描述任务描述</span></p>
  <p style="text-align: center; "><img src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20140428%2F20140428105758-240548409.jpg"></p>
  <p style="text-align: center; "><br></p>
  <p style="text-align: center; ">jjj</p>
  <p style="text-align: center; ">hjj</p>
  <p style="text-align: center; "><br></p>
  <p style="text-align: center; "><br></p>
  <p style="text-align: center; "><br></p>
  <p style="text-align: left;">bjju<i>hjjj</i>
  <embed src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4" />
  <img src="https://img1.baidu.com/it/u=395380977,272417941&fm=26&fmt=auto&gp=0.jpg"></p>
"""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        richText.apply {
            setRichText(html)
            setOnRichTextImageClickListener { imageUrls, position ->
                imgContainer
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                imageUrls.forEach {
                    val imgView = ImageView(this@MainActivity)
                    imgView.layoutParams = layoutParams
                    imgView.scaleType = ImageView.ScaleType.FIT_XY
                    GlideApp.with(context).load(it).into(imgView)
                    imgContainer.addView(imgView)
                }
            }
        }
    }
}