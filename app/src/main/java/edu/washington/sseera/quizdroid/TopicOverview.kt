package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class TopicOverview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)
        val questionIntent = Intent(this, QuestionPage::class.java)
        val startButton = findViewById(R.id.beginButton) as Button
        val topicDescription = findViewById(R.id.description) as TextView
        val topicName = findViewById(R.id.topic) as EditText
       // val numberOfQuestions = findViewById(R.id.numberOfQuestions) as TextView
        var questions = ""
        var answers = ""
        var correctAnswers =""

        var topicStuff = getIntent().getExtras();
        if (topicStuff != null) {
            topicDescription.setText(topicStuff.getString("description"));
            topicName.setText(topicStuff.getString("topic"))
//            numberOfQuestions.setText(topicStuff.getString("questions").length.toString())
            questions =  topicStuff.getString(questions)
            answers = topicStuff.getString(answers)
            correctAnswers = topicStuff.getString(correctAnswers)

        }








            startButton.setOnClickListener({ view ->
                intent.putExtra("questions", questions[0]);
                intent.putExtra("answers", answers);
                intent.putExtra("correctAnswers", correctAnswers[0]);
            startActivity(questionIntent)
        })
    }




}
