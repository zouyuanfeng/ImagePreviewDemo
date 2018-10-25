package com.itzyf.imagepreviewdemo

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase
import kotlinx.android.synthetic.main.fragment_preview_image.*

class PreviewItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_preview_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        image_view.displayType = ImageViewTouchBase.DisplayType.FIT_TO_SCREEN
        val item = arguments!!.get(ARGS_ITEM)
        if (item is Uri || item is String) {
            Glide.with(activity!!).load(item).into(image_view)
        }
    }

    fun resetView() {
        image_view.resetMatrix()
    }

    companion object {

        private const val ARGS_ITEM = "args_item"

        fun newInstance(item: Any?): PreviewItemFragment {
            val fragment = PreviewItemFragment()
            val bundle = Bundle()
            if (item is String)
                bundle.putString(ARGS_ITEM, item)
            else if (item is Uri)
                bundle.putParcelable(ARGS_ITEM, item)
            fragment.arguments = bundle
            return fragment
        }
    }
}