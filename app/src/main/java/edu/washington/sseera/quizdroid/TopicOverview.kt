package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TopicOverview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)
        val questionIntent = Intent(this, QuestionPage::class.java)
        val startButton = findViewById(R.id.beginButton) as Button
        startButton.setOnClickListener({ view ->
            startActivity(questionIntent)

        })
    }




}
