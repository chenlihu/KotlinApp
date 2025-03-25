package com.example.kotlinapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //需要注意的
        //是，不要在onReceive()方法中添加过多的逻辑或者进行任何的耗时操作，因为
        //BroadcastReceiver中是不允许开启线程的，当onReceive()方法运行了较长时间而没有结束时，程序就会出现错误。
        Toast.makeText(context, "boot", Toast.LENGTH_SHORT).show()
    }
}