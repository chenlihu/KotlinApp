package com.example.kotlinapp.sqlitetest

import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapp.R
import kotlin.text.insert
import androidx.core.database.sqlite.transaction

class SqliteMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sqlite_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 3)
        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            dbHelper.writableDatabase
        }
        // 添加数据
        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                // 开始组装第一条数据
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 454)
                put("price", 16.96)
            }
            db.insert("Book", null, values1)

            val values2 = ContentValues().apply {
                // 开始组装第二条数据
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, values2) // 插入第二条数据
        }

        // 更新数据
        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("price", 10.99)
            }
            val rows = db.update("Book", values, "name = ?", arrayOf("The Da Vinci Code"))
            Toast.makeText(this, "rows is $rows", Toast.LENGTH_SHORT).show()
        }

        // 删除
        val btn4 = findViewById<Button>(R.id.btn4)
        btn4.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book", "pages > ?", arrayOf("500"))
        }

        // 查询
        val btn5 = findViewById<Button>(R.id.btn5)
        btn5.setOnClickListener {
            val db = dbHelper.writableDatabase
            var cursor: Cursor? = null
            try {
                // 查询Book表中所有的数据
                cursor = db.query(
                    "Book",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
                )

                // 获取列索引（安全方式）
                val nameIndex = cursor.getColumnIndexOrThrow("name")
                val authorIndex = cursor.getColumnIndexOrThrow("author")
                val pagesIndex = cursor.getColumnIndexOrThrow("pages")
                val priceIndex = cursor.getColumnIndexOrThrow("price")

                if (cursor.moveToFirst()) {
                    do {
                        try {
                            // 安全获取数据
                            val name = cursor.getString(nameIndex)
                            val author = cursor.getString(authorIndex)
                            val pages = cursor.getInt(pagesIndex)
                            val price = cursor.getDouble(priceIndex)

                            Log.d("MainActivity", "book name is $name")
                            Log.d("MainActivity", "book author is $author")
                            Log.d("MainActivity", "book pages is $pages")
                            Log.d("MainActivity", "book price is $price")
                        } catch (e: Exception) {
                            Log.e("MainActivity", "Error reading cursor data: ${e.message}")
                        }
                    } while (cursor.moveToNext())
                } else {
                    Log.d("MainActivity", "No data found in Book table")
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Database query failed: ${e.message}")
            } finally {
                cursor?.close()
                db.close() // 记得关闭数据库连接
            }
        }

        // 替换
        val btn6 = findViewById<Button>(R.id.btn6)
        btn6.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.transaction() { // 开启事务
                delete("Book", null, null)
//                if (true) {
//                    // 在这里手动抛出一个异常，让事务失败
//                    throw NullPointerException()
//                }
                val values = contentValuesOf(
                    "name" to "Game of Thrones",
                    "author" to "George Martin",
                    "pages" to 720,
                    "price" to 20.85
                )
                insert("Book", null, values)

            }
        }
    }
}