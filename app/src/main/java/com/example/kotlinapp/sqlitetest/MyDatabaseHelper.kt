package com.example.kotlinapp.sqlitetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(val context: Context, name: String, version: Int): SQLiteOpenHelper(context, name, null, version) {

    private val createBook = """
        CREATE TABLE Book (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            author TEXT,
            price REAL,
            pages INTEGER,
            name TEXT,
            category_id INTEGER
        )
    """.trimIndent()

    private val createCategory = """
        CREATE TABLE Category (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            category_name TEXT,
            category_code INTEGER
        )
    """.trimIndent()

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createBook)
        db.execSQL(createCategory)
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        if (oldVersion <= 1) {
            db.execSQL(createCategory)
        }
        if (oldVersion <= 2) {
            db.execSQL("alter table Book add column category_id integer")
        }
    }
}