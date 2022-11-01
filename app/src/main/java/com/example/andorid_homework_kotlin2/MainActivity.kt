package com.example.andorid_homework_kotlin2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.andorid_homework_kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.activity_main)

        binding.button.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消"){ _,_ -> Toast.makeText(this,"dialog關閉",Toast.LENGTH_SHORT).show() }
                .setNegativeButton("自定義Toast"){ _,_ -> showToast()}
                .setPositiveButton("顯示list"){ _,_ -> showListDialog()}
                .show()
        }

    }

    private fun showToast(){
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP,0,50)
        toast.duration = Toast.LENGTH_SHORT

        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast,findViewById(R.id.custom_toast_root))
        toast.view = layout
        toast.show()
    }

    private fun showListDialog(){
        val list = arrayOf("message1","message2","message3","message4","message5")
        AlertDialog.Builder(this)
            .setTitle("使用LIST呈現")
            .setItems(list){_,i->Toast.makeText(this,"你選擇的是"+list[i],Toast.LENGTH_SHORT).show()}
            .show()
    }
}







