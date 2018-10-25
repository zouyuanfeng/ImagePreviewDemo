package com.itzyf.imagepreviewdemo


import android.view.ViewGroup

import java.util.ArrayList

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

/**
 * @author 依风听雨
 * @version 创建时间：2017/12/28 14:33
 */

class ImagePreviewPagerAdapter<T>(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {


    private var listener: OnPrimaryItemSetListener? = null

    private val mItems = ArrayList<T>()

    override fun getItem(position: Int): Fragment {
        return PreviewItemFragment.newInstance(mItems[position])
    }

    override fun getCount(): Int {
        return mItems.size
    }

    fun setOnPrimaryItemSetListener(listener: OnPrimaryItemSetListener) {
        this.listener = listener
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
        listener?.onPrimaryItemSet(position)
    }

    fun getPhotoItem(position: Int): T {
        return mItems[position]
    }

    fun addAll(items: List<T>) {
        mItems.addAll(items)
    }

    fun remove(position: Int) {
        mItems.removeAt(position)
        notifyDataSetChanged()
    }

    interface OnPrimaryItemSetListener {

        fun onPrimaryItemSet(position: Int)
    }


    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }
}
