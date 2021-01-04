package com.yasinkacmaz.coroutinesplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private val nameTextView: TextView by viewId(R.id.nameTextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.nameLiveData.observe(this) { name ->
            nameTextView.text = name
        }

        lifecycleScope.launchWhenStarted {
            delay(2000)
            if (lifecycle.currentState >= Lifecycle.State.STARTED) {
                // Our activity can be destroyed or moved to back while delay happening
                Toast.makeText(this@MainActivity, "Lifecycle Started", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
