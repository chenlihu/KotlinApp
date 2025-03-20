package com.example.kotlinapp.menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapp.R

// 注意这里的基类是 AppCompatActivity 不是 ComponentActivity
class MenuMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "add item", Toast.LENGTH_LONG).show()
            R.id.remove_item -> Toast.makeText(this, "remove item", Toast.LENGTH_LONG).show()
        }
        return true
    }
}