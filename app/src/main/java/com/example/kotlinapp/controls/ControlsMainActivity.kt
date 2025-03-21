package com.example.kotlinapp.controls

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapp.R

class ControlsMainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = this::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_controls_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1 = findViewById<Button>(R.id.button1)
        val progress_bar1 = findViewById<ProgressBar>(R.id.progress_bar1)
        button1.setOnClickListener {
            progress_bar1.progress = progress_bar1.progress + 5
        }

        val button_dialog = findViewById<Button>(R.id.btn_dialog)
        button_dialog.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_dialog -> {
                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("message")
                    setCancelable(false)
                    setPositiveButton("OK") { dialog, which ->
                        Log.i(TAG, "Positive Click")
                    }
                    setNegativeButton("Cancel", { dialog, which ->
                        Log.i(TAG, "Cancel Click")
                    })
                    show()
                }
            }
        }
    }
}