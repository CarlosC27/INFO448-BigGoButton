package edu.uw.ischool.cacs2340142.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import android.animation.ObjectAnimator

class MainActivity : AppCompatActivity() {


    var counter: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var myBigButton : Button = findViewById(R.id.bigButton)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var jigglingState : Boolean = false
        val jiggle = ObjectAnimator.ofFloat(myBigButton, "translationX", -10f, 10f).apply{
            duration = 25
            repeatCount = ObjectAnimator.INFINITE
        }

        myBigButton.setOnClickListener{
            counter++
            val myBackgroundColor: Int = Color.argb(255,( Random.nextInt()), (Random.nextInt()), (Random.nextInt()))
            val myTextColor: Int = Color.argb(255,( Random.nextInt()), (Random.nextInt()), (Random.nextInt()))
            when(counter) {
                1 -> myBigButton.setText("You have pushed me 1 time!")
                 else -> myBigButton.setText("You have pushed me $counter times!")
            }
            myBigButton.setBackgroundColor(myBackgroundColor)
            myBigButton.setTextColor(myTextColor)
            if(jigglingState == false){
                jiggle.start()
            } else {
                jiggle.cancel()
            }
            jigglingState = !jigglingState;

        }
    }
}