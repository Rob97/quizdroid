package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class QuestionPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_page)

        val answerIntent = Intent(this, answerView::class.java)
        val submitButton = findViewById(R.id.submitButton) as Button
        submitButton.setOnClickListener({ view ->
            startActivity(answerIntent)

        })
    }
}
