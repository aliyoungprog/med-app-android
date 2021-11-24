package com.example.medapp.utils

import android.os.SystemClock
import android.view.View

fun View.setSafeClickListener(
    onSafeClickListener: (View) -> Unit
) {
    val safeClickListener = SafeClickListener{
        onSafeClickListener(it)
    }
    setOnClickListener(safeClickListener)
}

class SafeClickListener(
    private val defaultInterval: Int = 1000,
    private val onSafeClickListener: (View) -> Unit
): View.OnClickListener{
    private var lastItemClickListener = 0L
    override fun onClick(v: View?) {
        if (SystemClock.elapsedRealtime() - lastItemClickListener < defaultInterval) return
        lastItemClickListener = SystemClock.elapsedRealtime()
        onSafeClickListener(v!!)
    }

}
