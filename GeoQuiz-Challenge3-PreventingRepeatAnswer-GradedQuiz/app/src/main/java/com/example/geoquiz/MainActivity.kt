package com.example.geoquiz

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private var correctAnswerNumber: Int = 0;

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
            isAnswerButtonEnable(false)
        }
        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
            isAnswerButtonEnable(false)
        }

        nextButton.setOnClickListener { view: View ->
            if (currentIndex == questionBank.size - 1) {
                Toast.makeText(
                    this,
                    "Your percentage of good answer is" + (correctAnswerNumber.toFloat() / questionBank.size.toFloat()) * 100 + '%',
                    Toast.LENGTH_LONG
                ).show()
                correctAnswerNumber = 0;
            }
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
            isAnswerButtonEnable(true)
        }

        updateQuestion()

    }

    private fun isAnswerButtonEnable(value: Boolean) {
        trueButton.isEnabled = value
        falseButton.isEnabled = value
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    /**
     * Dispatch onPause() to fragments.
     */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are *not* resumed.
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            correctAnswerNumber++
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(
            this,
            messageResId,
            Toast.LENGTH_SHORT
        ).show()
    }
}