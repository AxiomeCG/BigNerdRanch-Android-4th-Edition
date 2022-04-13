package com.example.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener { view: View -> makeToast(R.string.correct_toast, Gravity.TOP).show() }
        falseButton.setOnClickListener { view: View ->
            makeToast(R.string.incorrect_toast, Gravity.TOP).show()
        }


    }

    private fun makeToast(id: Int, gravity: Int): Toast {
        val toast = Toast.makeText(this, id , Toast.LENGTH_SHORT)
        toast.setGravity(gravity, 0, 0)
        return toast;
    }
}