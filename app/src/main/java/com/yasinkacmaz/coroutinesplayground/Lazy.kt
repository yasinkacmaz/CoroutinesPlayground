package com.yasinkacmaz.coroutinesplayground

fun <T> unsafeLazy(block: () -> T) = lazy(LazyThreadSafetyMode.NONE, block)
