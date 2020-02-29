package com.rishvaanth.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view:View){

        val buttonSelected = view as Button
        var cellId = 0
        when(buttonSelected.id){
            R.id.button_1-> cellId = 1
            R.id.button_2-> cellId = 2
            R.id.button_3-> cellId = 3
            R.id.button_4-> cellId = 4
            R.id.button_5-> cellId = 5
            R.id.button_6-> cellId = 6
            R.id.button_7-> cellId = 7
            R.id.button_8-> cellId = 8
            R.id.button_9-> cellId = 9

        }
        Toast.makeText(this, "Button $cellId is Clicked", Toast.LENGTH_SHORT).show()

    }
}
