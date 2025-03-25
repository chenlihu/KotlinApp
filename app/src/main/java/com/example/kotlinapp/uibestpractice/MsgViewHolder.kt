package com.example.kotlinapp.uibestpractice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.R

// 密封类，所有子类都必须在这个文件中
sealed class MsgViewHolder(view: View): RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View): MsgViewHolder(view) {
    val leftMsg = view.findViewById<TextView>(R.id.leftMsg)
}

class RightViewHolder(view: View): MsgViewHolder(view) {
    val rightMsg = view.findViewById<TextView>(R.id.rightMsg)
}