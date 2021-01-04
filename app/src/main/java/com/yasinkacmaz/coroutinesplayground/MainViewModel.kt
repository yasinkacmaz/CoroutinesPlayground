package com.yasinkacmaz.coroutinesplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class MainViewModel : ViewModel() {
    val nameLiveData = liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
        delay(3000)
        emit("yasin")
    }
}
