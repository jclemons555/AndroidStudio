package com.example.wordle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         fun checkGuess(guess: String) : String {
             var result = ""
             val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
             return result

        }

        val button = findViewById<Button>(R.id.Button)




        button.setOnClickListener {
            counter++
            val name:EditText = findViewById(R.id.input)
            val getName:TextView = findViewById(R.id.output)
            var str:String = name.toString()
            getName.setText(str)
            //val simpleEditText = findViewById<View>(R.id.input) as EditText
            //val guess = simpleEditText.text.toString()
            //TextView.text = guess
            if (counter == 2) {
                Toast.makeText(it.context, "One more guess left!", Toast.LENGTH_SHORT).show()
            }
            if (counter == 3) {
                Toast.makeText(it.context, "Out of guesses!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}