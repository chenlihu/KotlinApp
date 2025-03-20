package com.example.kotlinapp.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapp.R

class LifeCycleMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_main)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, LifeCycleDialogActivity::class.java)
            startActivity(intent)
        }
        Log.i("LifeCycleMainActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycleMainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycleMainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCycleMainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycleMainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycleMainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycleMainActivity", "onReStart")
    }
}