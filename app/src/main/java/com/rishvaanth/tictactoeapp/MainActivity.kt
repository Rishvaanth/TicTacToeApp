package com.rishvaanth.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt

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
//        Toast.makeText(this, "Button $cellId is Clicked", Toast.LENGTH_SHORT).show()
        playgame(cellId, buttonSelected)

    }

    var activeplayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()



    fun playgame(cellId:Int, buttonSelected:Button){
        if (activeplayer == 1) {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundResource(R.color.paleRed)
            player1.add(cellId)
            activeplayer = 2
            autoplay()
        }
        else {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundResource(R.color.paleGreen)
            player2.add(cellId)
            activeplayer = 1
        }
        buttonSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)) winner = 1
        if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)) winner = 2

        if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)) winner = 1
        if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)) winner = 2

        if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)) winner = 1
        if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)) winner = 2

        if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)) winner = 1
        if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)) winner = 2

        if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)) winner = 1
        if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)) winner = 2

        if (player1.contains(3)&&player1.contains(6)&&player1.contains(9)) winner = 1
        if (player2.contains(3)&&player2.contains(6)&&player2.contains(9)) winner = 2

        if (winner == 1) {Toast.makeText(this, "Player $winner wins!",Toast.LENGTH_SHORT).show()
            player1WinCount++
            restartGame()
        }
        else if (winner ==2){Toast.makeText(this, "Player $winner wins!",Toast.LENGTH_SHORT).show()
            player2WinCount++
            restartGame()
        }
        else if(player1.size + player2.size == 9) {Toast.makeText(this, "Its a Draw",Toast.LENGTH_SHORT).show()
            player1WinCount++
            player2WinCount++
            restartGame()
        }
    }
    fun autoplay(){
        var emptyCells = ArrayList<Int>()

        for (cellId in 1..9){
            if(!player1.contains(cellId)&&!player2.contains(cellId)){
                emptyCells.add(cellId)
            }
        }
        val r = java.util.Random()
        val randomIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randomIndex]

        var buttonSelected:Button?
        buttonSelected = when(cellId){
            1-> button_1
            2-> button_2
            3-> button_3
            4-> button_4
            5-> button_5
            6-> button_6
            7-> button_7
            8-> button_8
            9-> button_9
            else->{return}
        }
        playgame(cellId, buttonSelected)
    }
    fun restartGame(){
        player1.clear()
        player2.clear()

        for (i in 1..9){
            var buttonSelected:Button?= when(i){
                1-> button_1
                2-> button_2
                3-> button_3
                4-> button_4
                5-> button_5
                6-> button_6
                7-> button_7
                8-> button_8
                else->{button_9}
            }
            buttonSelected!!.text=""
            buttonSelected!!.setBackgroundResource(R.color.colorPrimary)
            buttonSelected.isEnabled =true
        }
        Toast.makeText(this, "Player 1 WinCount: ${player1WinCount}, Player 2 WinCount:${player2WinCount}",Toast.LENGTH_LONG).show()
    }
    var player1WinCount = 0
    var player2WinCount = 0

}
