package com.itzyf.imagepreviewdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_image_preview.*

/**
 * @author 依风听雨
 * @version 创建时间：2018/10/25 16:14
 */
class ImagePreviewActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    private lateinit var adapter: ImagePreviewPagerAdapter<String>
    private var mPreviousPos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview)
        val images = intent.getStringArrayListExtra("images")
        if (images == null) {
            tv_empty.visibility = View.VISIBLE
            return
        }
        val index = intent.getIntExtra("index", 0)

        adapter = ImagePreviewPagerAdapter(supportFragmentManager)
        adapter.addAll(images)

        pager.addOnPageChangeListener(this)
        pager.adapter = adapter
        pager.currentItem = index

        getString(R.string.preview_title, index, adapter.count)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }


    override fun onPageSelected(position: Int) {
        val adapter = pager.adapter as ImagePreviewPagerAdapter<*>
        if (mPreviousPos != -1 && mPreviousPos != position) {
            if (mPreviousPos >= adapter.count) {
                mPreviousPos = adapter.count - 1
            }
            (adapter.instantiateItem(pager, mPreviousPos) as PreviewItemFragment).resetView()
        }
        mPreviousPos = position
        title = getString(R.string.preview_title, mPreviousPos + 1, adapter.count)
    }

}