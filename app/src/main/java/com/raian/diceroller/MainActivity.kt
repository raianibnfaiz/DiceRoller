package com.raian.diceroller

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button )
        rollButton.setOnClickListener {

            rollDice()
        }
    }

    private fun rollDice() {
        val diceImage : ImageView = findViewById(R.id.imageView)
        val textRoll : TextView = findViewById(R.id.textView2)
        val textMsg : TextView = findViewById(R.id.textView3)
        val sideLayout : View = findViewById(R.id.sideLayout)
        val dice = Dice(6)
        val diceRoll = dice.roll()

        textRoll.text = diceRoll.toString()
        val drawableResource = when(diceRoll){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        when(diceRoll){
            1-> {
                textMsg.text = "Mono"
                sideLayout.setBackgroundColor(Color.parseColor("#45cdd7"))
            }
            6-> {textMsg.text = "Hexa"
                sideLayout.setBackgroundColor(Color.parseColor("#bbee7b"))
            }
            5-> {
                textMsg.text = "Penta"
                sideLayout.setBackgroundColor(Color.parseColor("#efe44b"))
            }
            2-> {
                textMsg.text = "Di"
                sideLayout.setBackgroundColor(Color.parseColor("#bbe9eb"))
            }
            3-> {
                textMsg.text = "Tri"
                sideLayout.setBackgroundColor(Color.parseColor("#cc5af1"))
            }
            4-> {
                textMsg.text = "Tetra"
                sideLayout.setBackgroundColor(Color.parseColor("#efb73e"))
            }

            else -> textMsg.text = ""
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }


    class Dice(val numSides : Int){
        fun roll() : Int {
            return(1..numSides).random()
        }
    }
}