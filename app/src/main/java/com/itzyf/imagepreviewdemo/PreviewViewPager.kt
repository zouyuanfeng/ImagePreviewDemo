package com.itzyf.imagepreviewdemo

import android.content.Context
import androidx.viewpager.widget.ViewPager
import android.util.AttributeSet
import android.view.View

import it.sephiroth.android.library.imagezoom.ImageViewTouch

class PreviewViewPager(context: Context, attrs: AttributeSet) : androidx.viewpager.widget.ViewPager(context, attrs) {

    override fun canScroll(v: View, checkV: Boolean, dx: Int, x: Int, y: Int): Boolean {
        return if (v is ImageViewTouch) {
            v.canScroll(dx) || super.canScroll(v, checkV, dx, x, y)
        } else super.canScroll(v, checkV, dx, x, y)
    }
}