package com.yasinkacmaz.coroutinesplayground

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

fun <T: View> Activity.viewId(@IdRes id: Int) = unsafeLazy { findViewById<T>(id) }
