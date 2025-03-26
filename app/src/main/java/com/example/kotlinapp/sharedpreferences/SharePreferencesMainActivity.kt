package com.example.kotlinapp.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapp.R

class SharePreferencesMainActivity : AppCompatActivity(), View.OnClickListener {
    val tag: String = "SharePreferencesMainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_share_preferences_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }

    // 数据被存储到 /data/data/com.example.sharedpreferencestest/shared_prefs/ 目录下

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn1 -> {
                getSharedPreferences("data", Context.MODE_PRIVATE).edit {
                    putString("name", "Tom")
                    putInt("age", 28)
                    putBoolean("married", false)
                }
            }
            R.id.btn2 -> {
                val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
                Log.d(tag, "name is " + prefs.getString("name", ""))
                Log.d(tag, "age is " + prefs.getInt("age", 0))
                Log.d(tag, "married is " + prefs.getBoolean("married", false))
            }
            else -> {

            }
        }
    }
}