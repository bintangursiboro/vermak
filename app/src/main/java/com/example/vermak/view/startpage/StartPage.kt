package com.example.vermak.view.startpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.vermak.R
import com.example.vermak.view.startpage.adapter.SlideAdapter

class StartPage : AppCompatActivity() {

    lateinit var viewPager : ViewPager
    lateinit var linear : LinearLayout
    lateinit var adapter : SlideAdapter

    lateinit var mDots : Array<TextView>

    lateinit var next : Button
    lateinit var back : Button

    private var mCurrentPage = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)
        viewPager = findViewById(R.id.viewPager)
        linear = findViewById(R.id.dots)
        next = findViewById(R.id.nextBtn)
        back = findViewById(R.id.backBtn)

        adapter = SlideAdapter(this)
        viewPager.adapter = adapter
        adddots(0)

        viewPager.addOnPageChangeListener(viewListener)

        next.setOnClickListener {
            viewPager.currentItem = mCurrentPage+1
        }

        back.setOnClickListener {
            viewPager.currentItem = mCurrentPage-1
        }
    }

    fun adddots(i : Int){
        mDots = Array<TextView>(3) {
            TextView(this)
        }
        linear.removeAllViews()

        for (x in 0..mDots.size){
            mDots[x].text = Html.fromHtml("&#8226;")
            mDots[x].setTextSize(35F)
            mDots[x].setTextColor(resources.getColor(R.color.colorGray))
            linear.addView(mDots[x])
        }

        if (mDots.size>0){
            mDots[i].setTextColor(resources.getColor(R.color.colorWhite))
        }
    }

    val viewListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
             //To change body of created functions use File | Settings | File Templates.
        }

        override fun onPageSelected(position: Int) {

        }

    }
}
