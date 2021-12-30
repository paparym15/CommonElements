package com.one.testnotifications

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

class CustomNestedScroll: AppBarLayout.Behavior {

    constructor() : super()
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    var shouldScroll = true

    override fun onStartNestedScroll(
        parent: CoordinatorLayout,
        child: AppBarLayout,
        directTargetChild: View,
        target: View,
        nestedScrollAxes: Int,
        type: Int
    ): Boolean {

        return shouldScroll
//                && when(target) {
//            is LinearLayout ->
//                return target.canScrollVertically(1) || target.canScrollVertically(-1)
//            else -> super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type)
//        }
    }
}