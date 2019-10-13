package com.example.vermak.view.startpage.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.vermak.R

class SlideAdapter(private val context : Context) : PagerAdapter() {
    lateinit var inflater : LayoutInflater

    var listImage = arrayOf(R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground)

    var list_title = arrayOf("Title 1 ", "Title 2", "Title 3")

    var list_description = arrayOf("Desc 1", "Desc 2", "Desc 3")

    var list_color = arrayOf(Color.rgb(0,0,0), Color.rgb(0,0,0), Color.rgb(0,0,0))

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view  = inflater.inflate(R.layout.activity_slide_1,container,false)

        var linearLayout = view.findViewById<LinearLayout>(R.id.slidelinearlayout)
        var img = view.findViewById<ImageView>(R.id.slideimg)
        var txt1 = view.findViewById<TextView>(R.id.slidetitle)
        var txt2 = view.findViewById<TextView>(R.id.slidedescription)

        img.setImageResource(listImage[position])
        txt1.text = list_title[position]
        txt2.text = list_description[position]
        linearLayout.setBackgroundColor(list_color[position])

        container.addView(view)

        return view
    }

    override fun isViewFromObject(view: View, layouts: Any): Boolean {
        return view == layouts as LinearLayout
    }

    override fun getCount(): Int {
        return list_color.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}